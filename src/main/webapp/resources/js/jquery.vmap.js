/*!
 * jQVMap Version 1.0 
 *
 * http://jqvmap.com
 *
 * Copyright 2012, Peter Schmalfeldt <manifestinteractive@gmail.com>
 * Copyright 2011-2012, Kirill Lebedev
 * Licensed under the MIT license.
 *
 * Fork Me @ https://github.com/manifestinteractive/jqvmap
 */
(function ($){

  var apiParams = {
    colors: 1,
    values: 1,
    backgroundColor: 1,
    scaleColors: 1,
    normalizeFunction: 1,
    enableZoom: 1,
    showTooltip: 1,
    borderColor: 1,
    borderWidth: 1,
    borderOpacity: 1,
    selectedRegion: 1
  };

  var apiEvents = {
    onLabelShow: 'labelShow',
    onRegionOver: 'regionMouseOver',
    onRegionOut: 'regionMouseOut',
    onRegionClick: 'regionClick'
  };

  $.fn.vectorMap = function (options){

    var defaultParams = {
      map: 'world_en',
      backgroundColor: '#a5bfdd',
      color: '#f4f3f0',
      hoverColor: '#c9dfaf',
	  selectedColor: '#c9dfaf',
      scaleColors: ['#b6d6ff', '#005ace'],
      normalizeFunction: 'linear',
      enableZoom: true,
      showTooltip: true,
      borderColor: '#818181',
      borderWidth: 1,
      borderOpacity: 0.25,
      selectedRegion: null
    }, map;

    if (options === 'addMap')
    {
      WorldMap.maps[arguments[1]] = arguments[2];
    }
    else if (options === 'set' && apiParams[arguments[1]])
    {
      this.data('mapObject')['set' + arguments[1].charAt(0).toUpperCase() + arguments[1].substr(1)].apply(this.data('mapObject'), Array.prototype.slice.call(arguments, 2));
    }
    else
    {
      $.extend(defaultParams, options);
      defaultParams.container = this;
      this.css({ position: 'relative', overflow: 'hidden' });
	  
      map = new WorldMap(defaultParams);

      this.data('mapObject', map);

      for (var e in apiEvents)
      {
        if (defaultParams[e])
        {
          this.bind(apiEvents[e] + '.jqvmap', defaultParams[e]);
        }
      }
    }
  };

  var VectorCanvas = function (width, height, params)
  {
    this.mode = window.SVGAngle ? 'svg' : 'vml';
	this.params = params;

    if (this.mode == 'svg')
    {
      this.createSvgNode = function (nodeName)
      {
        return document.createElementNS(this.svgns, nodeName);
      };
    }
    else
    {
      try {
        if (!document.namespaces.rvml)
        {
          document.namespaces.add("rvml", "urn:schemas-microsoft-com:vml");
        }
        this.createVmlNode = function (tagName)
        {
          return document.createElement('<rvml:' + tagName + ' class="rvml">');
        };
      }
      catch (e)
      {
        this.createVmlNode = function (tagName)
        {
          return document.createElement('<' + tagName + ' xmlns="urn:schemas-microsoft.com:vml" class="rvml">');
        };
      }

      document.createStyleSheet().addRule(".rvml", "behavior:url(#default#VML)");
    }

    if (this.mode == 'svg')
    {
      this.canvas = this.createSvgNode('svg');
    }
    else
    {
      this.canvas = this.createVmlNode('group');
      this.canvas.style.position = 'absolute';
    }

    this.setSize(width, height);
  };

  VectorCanvas.prototype = {
    svgns: "http://www.w3.org/2000/svg",
    mode: 'svg',
    width: 0,
    height: 0,
    canvas: null,

    setSize: function (width, height)
    {
      if (this.mode == 'svg')
      {
        this.canvas.setAttribute('width', width);
        this.canvas.setAttribute('height', height);
      }
      else
      {
        this.canvas.style.width = width + "px";
        this.canvas.style.height = height + "px";
        this.canvas.coordsize = width + ' ' + height;
        this.canvas.coordorigin = "0 0";
        if (this.rootGroup)
        {
          var pathes = this.rootGroup.getElementsByTagName('shape');
          for (var i = 0, l = pathes.length; i < l; i++)
          {
            pathes[i].coordsize = width + ' ' + height;
            pathes[i].style.width = width + 'px';
            pathes[i].style.height = height + 'px';
          }
          this.rootGroup.coordsize = width + ' ' + height;
          this.rootGroup.style.width = width + 'px';
          this.rootGroup.style.height = height + 'px';
        }
      }
      this.width = width;
      this.height = height;
    },

    createPath: function (config)
    {
      var node;
      if (this.mode == 'svg')
      {
        node = this.createSvgNode('path');
        node.setAttribute('d', config.path);

        if(this.params.borderColor !== null)
        {
          node.setAttribute('stroke', this.params.borderColor);
        }
        if(this.params.borderWidth > 0)
        {
          node.setAttribute('stroke-width', this.params.borderWidth);
          node.setAttribute('stroke-linecap', 'round');
          node.setAttribute('stroke-linejoin', 'round');
        }
        if(this.params.borderOpacity > 0)
        {
          node.setAttribute('stroke-opacity', this.params.borderOpacity);
        }

        node.setFill = function (color)
        {
          this.setAttribute("fill", "#5CB85C");
		  if(this.getAttribute("original") === null)
		  {
		  	this.setAttribute("original", color);
		  }
        };

        node.getFill = function (color)
        {
          return this.getAttribute("fill");
        };

        node.getOriginalFill = function ()
        {
		  return this.getAttribute("original");
        };
		
        node.setOpacity = function (opacity)
        {
          this.setAttribute('fill-opacity', opacity);
        };
      }
      else
      {
        node = this.createVmlNode('shape');
        node.coordorigin = "0 0";
        node.coordsize = this.width + ' ' + this.height;
        node.style.width = this.width + 'px';
        node.style.height = this.height + 'px';
        node.fillcolor = WorldMap.defaultFillColor;
        node.stroked = false;
        node.path = VectorCanvas.pathSvgToVml(config.path);

        var scale = this.createVmlNode('skew');
        scale.on = true;
        scale.matrix = '0.01,0,0,0.01,0,0';
        scale.offset = '0,0';

        node.appendChild(scale);

        var fill = this.createVmlNode('fill');
        node.appendChild(fill);

        node.setFill = function (color)
        {
          this.getElementsByTagName('fill')[0].color = color;
        };

        node.getFill = function (color)
        {
          return this.getElementsByTagName('fill')[0].color;
        };

        node.setOpacity = function (opacity)
        {
          this.getElementsByTagName('fill')[0].opacity = parseInt(opacity * 100, 10) + '%';
        };
      }
      return node;
    },

    createGroup: function (isRoot)
    {
      var node;
      if (this.mode == 'svg')
      {
        node = this.createSvgNode('g');
      }
      else
      {
        node = this.createVmlNode('group');
        node.style.width = this.width + 'px';
        node.style.height = this.height + 'px';
        node.style.left = '0px';
        node.style.top = '0px';
        node.coordorigin = "0 0";
        node.coordsize = this.width + ' ' + this.height;
      }

      if (isRoot)
      {
        this.rootGroup = node;
      }
      return node;
    },

    applyTransformParams: function (scale, transX, transY)
    {
      if (this.mode == 'svg')
      {
        this.rootGroup.setAttribute('transform', 'scale(' + scale + ') translate(' + transX + ', ' + transY + ')');
      }
      else
      {
        this.rootGroup.coordorigin = (this.width - transX) + ',' + (this.height - transY);
        this.rootGroup.coordsize = this.width / scale + ',' + this.height / scale;
      }
    }
  };

  VectorCanvas.pathSvgToVml = function (path)
  {
    var result = '';
    var cx = 0, cy = 0, ctrlx, ctrly;

    return path.replace(/([MmLlHhVvCcSs])((?:-?(?:\d+)?(?:\.\d+)?,?\s?)+)/g, function (segment, letter, coords, index)
    {
      coords = coords.replace(/(\d)-/g, '$1,-').replace(/\s+/g, ',').split(',');
      if (!coords[0])
      {
        coords.shift();
      }

      for (var i = 0, l = coords.length; i < l; i++)
      {
        coords[i] = Math.round(100 * coords[i]);
      }

      switch (letter)
      {
        case 'm':
          cx += coords[0];
          cy += coords[1];
          return 't' + coords.join(',');
          break;

        case 'M':
          cx = coords[0];
          cy = coords[1];
          return 'm' + coords.join(',');
          break;

        case 'l':
          cx += coords[0];
          cy += coords[1];
          return 'r' + coords.join(',');
          break;

        case 'L':
          cx = coords[0];
          cy = coords[1];
          return 'l' + coords.join(',');
          break;

        case 'h':
          cx += coords[0];
          return 'r' + coords[0] + ',0';
          break;

        case 'H':
          cx = coords[0];
          return 'l' + cx + ',' + cy;
          break;

        case 'v':
          cy += coords[0];
          return 'r0,' + coords[0];
          break;

        case 'V':
          cy = coords[0];
          return 'l' + cx + ',' + cy;
          break;

        case 'c':
          ctrlx = cx + coords[coords.length - 4];
          ctrly = cy + coords[coords.length - 3];
          cx += coords[coords.length - 2];
          cy += coords[coords.length - 1];
          return 'v' + coords.join(',');
          break;

        case 'C':
          ctrlx = coords[coords.length - 4];
          ctrly = coords[coords.length - 3];
          cx = coords[coords.length - 2];
          cy = coords[coords.length - 1];
          return 'c' + coords.join(',');
          break;

        case 's':
          coords.unshift(cy - ctrly);
          coords.unshift(cx - ctrlx);
          ctrlx = cx + coords[coords.length - 4];
          ctrly = cy + coords[coords.length - 3];
          cx += coords[coords.length - 2];
          cy += coords[coords.length - 1];
          return 'v' + coords.join(',');
          break;

        case 'S':
          coords.unshift(cy + cy - ctrly);
          coords.unshift(cx + cx - ctrlx);
          ctrlx = coords[coords.length - 4];
          ctrly = coords[coords.length - 3];
          cx = coords[coords.length - 2];
          cy = coords[coords.length - 1];
          return 'c' + coords.join(',');
          break;
		  
		default:
		  return false;
		  break;
      }

      return '';

    }).replace(/z/g, '');
  };

  var WorldMap = function (params)
  {
    params = params || {};
	var map = this;
    var mapData = WorldMap.maps[params.map];

    this.container = params.container;

    this.defaultWidth = mapData.width;
    this.defaultHeight = mapData.height;

    this.color = params.color;
    this.hoverColor = params.hoverColor;
    //this.setBackgroundColor(params.backgroundColor);

    this.width = params.container.width();
    this.height = params.container.height();

    this.resize();

    jQuery(window).resize(function ()
    {
      map.width = params.container.width();
      map.height = params.container.height();
      map.resize();
      map.canvas.setSize(map.width, map.height);
      map.applyTransform();
    });

    this.canvas = new VectorCanvas(this.width, this.height, params);
    params.container.append(this.canvas.canvas);

    this.makeDraggable();

    this.rootGroup = this.canvas.createGroup(true);

    this.index = WorldMap.mapIndex;
    this.label = jQuery('<div/>').addClass('jqvmap-label').appendTo(jQuery('body'));

    if(params.enableZoom)
    {
      jQuery('<div/>').addClass('jqvmap-zoomin').text('+').appendTo(params.container);
      jQuery('<div/>').addClass('jqvmap-zoomout').html('&#x2212;').appendTo(params.container);
    }
	
	map.countries = [];
	
    for (var key in mapData.pathes)
    {
      var path = this.canvas.createPath({
        path: mapData.pathes[key].path
      });
	  
      path.setFill(this.color);
      path.id = 'jqvmap' + map.index + '_' + key;
      map.countries[key] = path;
	  
      jQuery(this.rootGroup).append(path);

      path.setAttribute('class', 'jqvmap-region');

      if(params.selectedRegion !== null)
      {
        if(key.toLowerCase() == params.selectedRegion.toLowerCase())
        {
          path.setFill(params.selectedColor);
        }
      }
    }

    jQuery(params.container).delegate(this.canvas.mode == 'svg' ? 'path' : 'shape', 'mouseover mouseout', function (e){
      var path = e.target,
      code = e.target.id.split('_').pop(),
      labelShowEvent = $.Event('labelShow.jqvmap'),
      regionMouseOverEvent = $.Event('regionMouseOver.jqvmap');

      if (e.type == 'mouseover')
      {
        jQuery(params.container).trigger(regionMouseOverEvent, [code, mapData.pathes[code].name]);
        if (!regionMouseOverEvent.isDefaultPrevented())
        {
          if (params.hoverOpacity)
          {
            path.setOpacity(params.hoverOpacity);
          }
          else if (params.hoverColor)
          {
            path.currentFillColor = path.getFill() + '';
            path.setFill(params.hoverColor);
          }
        }
        if(params.showTooltip)
        {
          map.label.text(mapData.pathes[code].name);
          jQuery(params.container).trigger(labelShowEvent, [map.label, code]);

          if (!labelShowEvent.isDefaultPrevented())
          {
            map.label.show();
            map.labelWidth = map.label.width();
            map.labelHeight = map.label.height();
          }
        }
      }
      else
      {
        path.setOpacity(1);
        if (path.currentFillColor)
        {
          path.setFill(path.currentFillColor);
        }

        map.label.hide();
        jQuery(params.container).trigger('regionMouseOut.jqvmap', [code, mapData.pathes[code].name]);
      }
    });

    jQuery(params.container).delegate(this.canvas.mode == 'svg' ? 'path' : 'shape', 'click', function (e){

	  for (var key in mapData.pathes)
      {
		map.countries[key].currentFillColor = map.countries[key].getOriginalFill();
        map.countries[key].setFill(map.countries[key].getOriginalFill());
      }

      var path = e.target;
      var code = e.target.id.split('_').pop();

      jQuery(params.container).trigger('regionClick.jqvmap', [code, mapData.pathes[code].name]);

	  path.currentFillColor = params.selectedColor;
      path.setFill(params.selectedColor);

    });

    if(params.showTooltip)
    {
      params.container.mousemove(function (e){
        if (map.label.is(':visible'))
        {
          map.label.css({
            left: e.pageX - 15 - map.labelWidth,
            top: e.pageY - 15 - map.labelHeight
          });
        }
      });
    }

    this.setColors(params.colors);

    this.canvas.canvas.appendChild(this.rootGroup);

    this.applyTransform();

    this.colorScale = new ColorScale(params.scaleColors, params.normalizeFunction, params.valueMin, params.valueMax);

    if (params.values)
    {
      this.values = params.values;
      this.setValues(params.values);
    }

    this.bindZoomButtons();

    WorldMap.mapIndex++;
  };

  WorldMap.prototype = {
    transX: 0,
    transY: 0,
    scale: 1,
    baseTransX: 0,
    baseTransY: 0,
    baseScale: 1,
    width: 0,
    height: 0,
    countries: {},
    countriesColors: {},
    countriesData: {},
    zoomStep: 1.4,
    zoomMaxStep: 4,
    zoomCurStep: 1,

    setColors: function (key, color)
    {
      if (typeof key == 'string')
      {
        this.countries[key].setFill(color);
  	  	this.countries[key].setAttribute("original", color);
      }
      else
      {
        var colors = key;

        for (var code in colors)
        {
          if (this.countries[code])
          {
            this.countries[code].setFill(colors[code]);
			this.countries[code].setAttribute("original", colors[code]);
          }
        }
      }
    },

    setValues: function (values)
    {
      var max = 0,
      min = Number.MAX_VALUE,
      val;

      for (var cc in values)
      {
        val = parseFloat(values[cc]);
        if (val > max)
        {
          max = values[cc];
        }
        if (val && val < min)
        {
          min = val;
        }
      }

      this.colorScale.setMin(min);
      this.colorScale.setMax(max);

      var colors = {};
      for (cc in values)
      {
        val = parseFloat(values[cc]);
        if (val)
        {
          colors[cc] = this.colorScale.getColor(val);
        }
        else
        {
          colors[cc] = this.color;
        }
      }
      this.setColors(colors);
      this.values = values;
    },

    setBackgroundColor: function (backgroundColor)
    {
      this.container.css('background-color', backgroundColor);
    },

    setScaleColors: function (colors)
    {
      this.colorScale.setColors(colors);

      if (this.values)
      {
        this.setValues(this.values);
      }
    },

    setNormalizeFunction: function (f)
    {
      this.colorScale.setNormalizeFunction(f);

      if (this.values)
      {
        this.setValues(this.values);
      }
    },

    resize: function ()
    {
      var curBaseScale = this.baseScale;
      if (this.width / this.height > this.defaultWidth / this.defaultHeight)
      {
        this.baseScale = this.height / this.defaultHeight;
        this.baseTransX = Math.abs(this.width - this.defaultWidth * this.baseScale) / (2 * this.baseScale);
      }
      else
      {
        this.baseScale = this.width / this.defaultWidth;
        this.baseTransY = Math.abs(this.height - this.defaultHeight * this.baseScale) / (2 * this.baseScale);
      }
      this.scale *= this.baseScale / curBaseScale;
      this.transX *= this.baseScale / curBaseScale;
      this.transY *= this.baseScale / curBaseScale;
    },

    reset: function ()
    {
      this.countryTitle.reset();
      for (var key in this.countries)
      {
        this.countries[key].setFill(WorldMap.defaultColor);
      }
      this.scale = this.baseScale;
      this.transX = this.baseTransX;
      this.transY = this.baseTransY;
      this.applyTransform();
    },

    applyTransform: function ()
    {
      var maxTransX, maxTransY, minTransX, minTransY;
      if (this.defaultWidth * this.scale <= this.width)
      {
        maxTransX = (this.width - this.defaultWidth * this.scale) / (2 * this.scale);
        minTransX = (this.width - this.defaultWidth * this.scale) / (2 * this.scale);
      }
      else
      {
        maxTransX = 0;
        minTransX = (this.width - this.defaultWidth * this.scale) / this.scale;
      }

      if (this.defaultHeight * this.scale <= this.height)
      {
        maxTransY = (this.height - this.defaultHeight * this.scale) / (2 * this.scale);
        minTransY = (this.height - this.defaultHeight * this.scale) / (2 * this.scale);
      }
      else
      {
        maxTransY = 0;
        minTransY = (this.height - this.defaultHeight * this.scale) / this.scale;
      }

      if (this.transY > maxTransY)
      {
        this.transY = maxTransY;
      }
      else if (this.transY < minTransY)
      {
        this.transY = minTransY;
      }
      if (this.transX > maxTransX)
      {
        this.transX = maxTransX;
      }
      else if (this.transX < minTransX)
      {
        this.transX = minTransX;
      }

      this.canvas.applyTransformParams(this.scale, this.transX, this.transY);
    },

    makeDraggable: function ()
    {
      var mouseDown = false;
      var oldPageX, oldPageY;
      var self = this;

      this.container.mousemove(function (e){

        if (mouseDown)
        {
          var curTransX = self.transX;
          var curTransY = self.transY;

          self.transX -= (oldPageX - e.pageX) / self.scale;
          self.transY -= (oldPageY - e.pageY) / self.scale;

          self.applyTransform();

          oldPageX = e.pageX;
          oldPageY = e.pageY;
        }

        return false;

      }).mousedown(function (e){

        mouseDown = true;
        oldPageX = e.pageX;
        oldPageY = e.pageY;

        return false;

      }).mouseup(function (){

        mouseDown = false;
        return false;

      });
    },

    bindZoomButtons: function ()
    {
      var map = this;
      var sliderDelta = (jQuery('#zoom').innerHeight() - 6 * 2 - 15 * 2 - 3 * 2 - 7 - 6) / (this.zoomMaxStep - this.zoomCurStep);

      this.container.find('.jqvmap-zoomin').click(function ()
      {
        if (map.zoomCurStep < map.zoomMaxStep)
        {
          var curTransX = map.transX;
          var curTransY = map.transY;
          var curScale = map.scale;

          map.transX -= (map.width / map.scale - map.width / (map.scale * map.zoomStep)) / 2;
          map.transY -= (map.height / map.scale - map.height / (map.scale * map.zoomStep)) / 2;
          map.setScale(map.scale * map.zoomStep);
          map.zoomCurStep++;

          jQuery('#zoomSlider').css('top', parseInt(jQuery('#zoomSlider').css('top'), 10) - sliderDelta);
        }
      });

      this.container.find('.jqvmap-zoomout').click(function ()
      {
        if (map.zoomCurStep > 1) {
          var curTransX = map.transX;
          var curTransY = map.transY;
          var curScale = map.scale;

          map.transX += (map.width / (map.scale / map.zoomStep) - map.width / map.scale) / 2;
          map.transY += (map.height / (map.scale / map.zoomStep) - map.height / map.scale) / 2;
          map.setScale(map.scale / map.zoomStep);
          map.zoomCurStep--;

          jQuery('#zoomSlider').css('top', parseInt(jQuery('#zoomSlider').css('top'), 10) + sliderDelta);
        }
      });
    },

    setScale: function (scale)
    {
      this.scale = scale;
      this.applyTransform();
    },

    getCountryPath: function (cc)
    {
      return jQuery('#' + cc)[0];
    }
  };

  WorldMap.xlink = "http://www.w3.org/1999/xlink";
  WorldMap.mapIndex = 1;
  WorldMap.maps = {};

  var ColorScale = function (colors, normalizeFunction, minValue, maxValue)
  {
    if (colors)
    {
      this.setColors(colors);
    }
    if (normalizeFunction)
    {
      this.setNormalizeFunction(normalizeFunction);
    }
    if (minValue)
    {
      this.setMin(minValue);
    }
    if (minValue)
    {
      this.setMax(maxValue);
    }
  };

  ColorScale.prototype = {
    colors: [],

    setMin: function (min)
    {
      this.clearMinValue = min;

      if (typeof this.normalize === 'function')
      {
        this.minValue = this.normalize(min);
      }
      else
      {
        this.minValue = min;
      }
    },

    setMax: function (max)
    {
      this.clearMaxValue = max;
      if (typeof this.normalize === 'function')
      {
        this.maxValue = this.normalize(max);
      }
      else
      {
        this.maxValue = max;
      }
    },

    setColors: function (colors)
    {
      for (var i = 0; i < colors.length; i++)
      {
        colors[i] = ColorScale.rgbToArray(colors[i]);
      }
      this.colors = colors;
    },

    setNormalizeFunction: function (f)
    {
      if (f === 'polynomial')
      {
        this.normalize = function (value)
        {
          return Math.pow(value, 0.2);
        };
      }
      else if (f === 'linear')
      {
        delete this.normalize;
      }
      else
      {
        this.normalize = f;
      }
      this.setMin(this.clearMinValue);
      this.setMax(this.clearMaxValue);
    },

    getColor: function (value)
    {
      if (typeof this.normalize === 'function')
      {
        value = this.normalize(value);
      }

      var lengthes = [];
      var fullLength = 0;
      var l;

      for (var i = 0; i < this.colors.length - 1; i++)
      {
        l = this.vectorLength(this.vectorSubtract(this.colors[i + 1], this.colors[i]));
        lengthes.push(l);
        fullLength += l;
      }

      var c = (this.maxValue - this.minValue) / fullLength;

      for (i = 0; i < lengthes.length; i++)
      {
        lengthes[i] *= c;
      }

      i = 0;
      value -= this.minValue;

      while (value - lengthes[i] >= 0)
      {
        value -= lengthes[i];
        i++;
      }

      var color;
      if (i == this.colors.length - 1)
      {
        color = this.vectorToNum(this.colors[i]).toString(16);
      }
      else
      {
        color = (this.vectorToNum(this.vectorAdd(this.colors[i], this.vectorMult(this.vectorSubtract(this.colors[i + 1], this.colors[i]), (value) / (lengthes[i]))))).toString(16);
      }

      while (color.length < 6)
      {
        color = '0' + color;
      }
      return '#' + color;
    },

    vectorToNum: function (vector)
    {
      var num = 0;
      for (var i = 0; i < vector.length; i++)
      {
        num += Math.round(vector[i]) * Math.pow(256, vector.length - i - 1);
      }
      return num;
    },

    vectorSubtract: function (vector1, vector2)
    {
      var vector = [];
      for (var i = 0; i < vector1.length; i++)
      {
        vector[i] = vector1[i] - vector2[i];
      }
      return vector;
    },

    vectorAdd: function (vector1, vector2)
    {
      var vector = [];
      for (var i = 0; i < vector1.length; i++)
      {
        vector[i] = vector1[i] + vector2[i];
      }
      return vector;
    },

    vectorMult: function (vector, num)
    {
      var result = [];
      for (var i = 0; i < vector.length; i++)
      {
        result[i] = vector[i] * num;
      }
      return result;
    },

    vectorLength: function (vector)
    {
      var result = 0;
      for (var i = 0; i < vector.length; i++)
      {
        result += vector[i] * vector[i];
      }
      return Math.sqrt(result);
    }
  };

  ColorScale.arrayToRgb = function (ar)
  {
    var rgb = '#';
    var d;
    for (var i = 0; i < ar.length; i++)
    {
      d = ar[i].toString(16);
      rgb += d.length == 1 ? '0' + d : d;
    }
    return rgb;
  };

  ColorScale.rgbToArray = function (rgb)
  {
    rgb = rgb.substr(1);
    return [parseInt(rgb.substr(0, 2), 16), parseInt(rgb.substr(2, 2), 16), parseInt(rgb.substr(4, 2), 16)];
  };

})(jQuery);




var mul_table = [
        512,512,456,512,328,456,335,512,405,328,271,456,388,335,292,512,
        454,405,364,328,298,271,496,456,420,388,360,335,312,292,273,512,
        482,454,428,405,383,364,345,328,312,298,284,271,259,496,475,456,
        437,420,404,388,374,360,347,335,323,312,302,292,282,273,265,512,
        497,482,468,454,441,428,417,405,394,383,373,364,354,345,337,328,
        320,312,305,298,291,284,278,271,265,259,507,496,485,475,465,456,
        446,437,428,420,412,404,396,388,381,374,367,360,354,347,341,335,
        329,323,318,312,307,302,297,292,287,282,278,273,269,265,261,512,
        505,497,489,482,475,468,461,454,447,441,435,428,422,417,411,405,
        399,394,389,383,378,373,368,364,359,354,350,345,341,337,332,328,
        324,320,316,312,309,305,301,298,294,291,287,284,281,278,274,271,
        268,265,262,259,257,507,501,496,491,485,480,475,470,465,460,456,
        451,446,442,437,433,428,424,420,416,412,408,404,400,396,392,388,
        385,381,377,374,370,367,363,360,357,354,350,347,344,341,338,335,
        332,329,326,323,320,318,315,312,310,307,304,302,299,297,294,292,
        289,287,285,282,280,278,275,273,271,269,267,265,263,261,259];
        
   
var shg_table = [
	     9, 11, 12, 13, 13, 14, 14, 15, 15, 15, 15, 16, 16, 16, 16, 17, 
		17, 17, 17, 17, 17, 17, 18, 18, 18, 18, 18, 18, 18, 18, 18, 19, 
		19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 20, 20, 20,
		20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 21,
		21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21,
		21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 22, 22, 22, 22, 22, 22, 
		22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22,
		22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 23, 
		23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23,
		23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23,
		23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 
		23, 23, 23, 23, 23, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 
		24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24,
		24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24,
		24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24,
		24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24 ];


function stackBlurCanvasRGBA( canvas, top_x, top_y, width, height, radius )
{
	if ( isNaN(radius) || radius < 1 ) return;
	radius |= 0;
	
	var context = canvas.getContext("2d");
	var imageData;
	
	try {
	  try {
		imageData = context.getImageData( top_x, top_y, width, height );
	  } catch(e) {
	  
		// NOTE: this part is supposedly only needed if you want to work with local files
		// so it might be okay to remove the whole try/catch block and just use
		// imageData = context.getImageData( top_x, top_y, width, height );
		try {
			netscape.security.PrivilegeManager.enablePrivilege("UniversalBrowserRead");
			imageData = context.getImageData( top_x, top_y, width, height );
		} catch(e) {
			alert("Cannot access local image");
			throw new Error("unable to access local image data: " + e);
			return;
		}
	  }
	} catch(e) {
	  alert("Cannot access image");
	  throw new Error("unable to access image data: " + e);
	}
			
	var pixels = imageData.data;
			
	var x, y, i, p, yp, yi, yw, r_sum, g_sum, b_sum, a_sum, 
	r_out_sum, g_out_sum, b_out_sum, a_out_sum,
	r_in_sum, g_in_sum, b_in_sum, a_in_sum, 
	pr, pg, pb, pa, rbs;
			
	var div = radius + radius + 1;
	var w4 = width << 2;
	var widthMinus1  = width - 1;
	var heightMinus1 = height - 1;
	var radiusPlus1  = radius + 1;
	var sumFactor = radiusPlus1 * ( radiusPlus1 + 1 ) / 2;
	
	var stackStart = new BlurStack();
	var stack = stackStart;
	for ( i = 1; i < div; i++ )
	{
		stack = stack.next = new BlurStack();
		if ( i == radiusPlus1 ) var stackEnd = stack;
	}
	stack.next = stackStart;
	var stackIn = null;
	var stackOut = null;
	
	yw = yi = 0;
	
	var mul_sum = mul_table[radius];
	var shg_sum = shg_table[radius];
	
	for ( y = 0; y < height; y++ )
	{
		r_in_sum = g_in_sum = b_in_sum = a_in_sum = r_sum = g_sum = b_sum = a_sum = 0;
		
		r_out_sum = radiusPlus1 * ( pr = pixels[yi] );
		g_out_sum = radiusPlus1 * ( pg = pixels[yi+1] );
		b_out_sum = radiusPlus1 * ( pb = pixels[yi+2] );
		a_out_sum = radiusPlus1 * ( pa = pixels[yi+3] );
		
		r_sum += sumFactor * pr;
		g_sum += sumFactor * pg;
		b_sum += sumFactor * pb;
		a_sum += sumFactor * pa;
		
		stack = stackStart;
		
		for( i = 0; i < radiusPlus1; i++ )
		{
			stack.r = pr;
			stack.g = pg;
			stack.b = pb;
			stack.a = pa;
			stack = stack.next;
		}
		
		for( i = 1; i < radiusPlus1; i++ )
		{
			p = yi + (( widthMinus1 < i ? widthMinus1 : i ) << 2 );
			r_sum += ( stack.r = ( pr = pixels[p])) * ( rbs = radiusPlus1 - i );
			g_sum += ( stack.g = ( pg = pixels[p+1])) * rbs;
			b_sum += ( stack.b = ( pb = pixels[p+2])) * rbs;
			a_sum += ( stack.a = ( pa = pixels[p+3])) * rbs;
			
			r_in_sum += pr;
			g_in_sum += pg;
			b_in_sum += pb;
			a_in_sum += pa;
			
			stack = stack.next;
		}
		
		
		stackIn = stackStart;
		stackOut = stackEnd;
		for ( x = 0; x < width; x++ )
		{
			pixels[yi+3] = pa = (a_sum * mul_sum) >> shg_sum;
			if ( pa != 0 )
			{
				pa = 255 / pa;
				pixels[yi]   = ((r_sum * mul_sum) >> shg_sum) * pa;
				pixels[yi+1] = ((g_sum * mul_sum) >> shg_sum) * pa;
				pixels[yi+2] = ((b_sum * mul_sum) >> shg_sum) * pa;
			} else {
				pixels[yi] = pixels[yi+1] = pixels[yi+2] = 0;
			}
			
			r_sum -= r_out_sum;
			g_sum -= g_out_sum;
			b_sum -= b_out_sum;
			a_sum -= a_out_sum;
			
			r_out_sum -= stackIn.r;
			g_out_sum -= stackIn.g;
			b_out_sum -= stackIn.b;
			a_out_sum -= stackIn.a;
			
			p =  ( yw + ( ( p = x + radius + 1 ) < widthMinus1 ? p : widthMinus1 ) ) << 2;
			
			r_in_sum += ( stackIn.r = pixels[p]);
			g_in_sum += ( stackIn.g = pixels[p+1]);
			b_in_sum += ( stackIn.b = pixels[p+2]);
			a_in_sum += ( stackIn.a = pixels[p+3]);
			
			r_sum += r_in_sum;
			g_sum += g_in_sum;
			b_sum += b_in_sum;
			a_sum += a_in_sum;
			
			stackIn = stackIn.next;
			
			r_out_sum += ( pr = stackOut.r );
			g_out_sum += ( pg = stackOut.g );
			b_out_sum += ( pb = stackOut.b );
			a_out_sum += ( pa = stackOut.a );
			
			r_in_sum -= pr;
			g_in_sum -= pg;
			b_in_sum -= pb;
			a_in_sum -= pa;
			
			stackOut = stackOut.next;

			yi += 4;
		}
		yw += width;
	}

	
	for ( x = 0; x < width; x++ )
	{
		g_in_sum = b_in_sum = a_in_sum = r_in_sum = g_sum = b_sum = a_sum = r_sum = 0;
		
		yi = x << 2;
		r_out_sum = radiusPlus1 * ( pr = pixels[yi]);
		g_out_sum = radiusPlus1 * ( pg = pixels[yi+1]);
		b_out_sum = radiusPlus1 * ( pb = pixels[yi+2]);
		a_out_sum = radiusPlus1 * ( pa = pixels[yi+3]);
		
		r_sum += sumFactor * pr;
		g_sum += sumFactor * pg;
		b_sum += sumFactor * pb;
		a_sum += sumFactor * pa;
		
		stack = stackStart;
		
		for( i = 0; i < radiusPlus1; i++ )
		{
			stack.r = pr;
			stack.g = pg;
			stack.b = pb;
			stack.a = pa;
			stack = stack.next;
		}
		
		yp = width;
		
		for( i = 1; i <= radius; i++ )
		{
			yi = ( yp + x ) << 2;
			
			r_sum += ( stack.r = ( pr = pixels[yi])) * ( rbs = radiusPlus1 - i );
			g_sum += ( stack.g = ( pg = pixels[yi+1])) * rbs;
			b_sum += ( stack.b = ( pb = pixels[yi+2])) * rbs;
			a_sum += ( stack.a = ( pa = pixels[yi+3])) * rbs;
		   
			r_in_sum += pr;
			g_in_sum += pg;
			b_in_sum += pb;
			a_in_sum += pa;
			
			stack = stack.next;
		
			if( i < heightMinus1 )
			{
				yp += width;
			}
		}
		
		yi = x;
		stackIn = stackStart;
		stackOut = stackEnd;
		for ( y = 0; y < height; y++ )
		{
			p = yi << 2;
			pixels[p+3] = pa = (a_sum * mul_sum) >> shg_sum;
			if ( pa > 0 )
			{
				pa = 255 / pa;
				pixels[p]   = ((r_sum * mul_sum) >> shg_sum ) * pa;
				pixels[p+1] = ((g_sum * mul_sum) >> shg_sum ) * pa;
				pixels[p+2] = ((b_sum * mul_sum) >> shg_sum ) * pa;
			} else {
				pixels[p] = pixels[p+1] = pixels[p+2] = 0;
			}
			
			r_sum -= r_out_sum;
			g_sum -= g_out_sum;
			b_sum -= b_out_sum;
			a_sum -= a_out_sum;
		   
			r_out_sum -= stackIn.r;
			g_out_sum -= stackIn.g;
			b_out_sum -= stackIn.b;
			a_out_sum -= stackIn.a;
			
			p = ( x + (( ( p = y + radiusPlus1) < heightMinus1 ? p : heightMinus1 ) * width )) << 2;
			
			r_sum += ( r_in_sum += ( stackIn.r = pixels[p]));
			g_sum += ( g_in_sum += ( stackIn.g = pixels[p+1]));
			b_sum += ( b_in_sum += ( stackIn.b = pixels[p+2]));
			a_sum += ( a_in_sum += ( stackIn.a = pixels[p+3]));
		   
			stackIn = stackIn.next;
			
			r_out_sum += ( pr = stackOut.r );
			g_out_sum += ( pg = stackOut.g );
			b_out_sum += ( pb = stackOut.b );
			a_out_sum += ( pa = stackOut.a );
			
			r_in_sum -= pr;
			g_in_sum -= pg;
			b_in_sum -= pb;
			a_in_sum -= pa;
			
			stackOut = stackOut.next;
			
			yi += width;
		}
	}
	
	context.putImageData( imageData, top_x, top_y );
	
}

function BlurStack()
{
	this.r = 0;
	this.g = 0;
	this.b = 0;
	this.a = 0;
	this.next = null;
}

$( document ).ready(function() {
  var BLUR_RADIUS = 40;
  var sourceImages = [];

  $('.src-image').each(function(){
    sourceImages.push($(this).attr('src'));
  });

  $('.avatar img').each(function(index){
    $(this).attr('src', sourceImages[index] );
  });

  var drawBlur = function(canvas, image) {
    var w = canvas.width;
    var h = canvas.height;
    var canvasContext = canvas.getContext('2d');
    canvasContext.drawImage(image, 0, 0, w, h);
    stackBlurCanvasRGBA(canvas, 0, 0, w, h, BLUR_RADIUS);
  }; 
    
  
  $('.card canvas').each(function(index){
    var canvas = $(this)[0];
    
    var image = new Image();
    image.src = sourceImages[index];
    
    image.onload = function() {
      drawBlur(canvas, image);
    }
  });
});

