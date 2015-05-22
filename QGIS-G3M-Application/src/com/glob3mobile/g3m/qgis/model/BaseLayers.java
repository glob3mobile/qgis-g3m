

package com.glob3mobile.g3m.qgis.model;

import org.glob3.mobile.generated.Layer;
import org.glob3.mobile.generated.OSMLayer;
import org.glob3.mobile.generated.Sector;
import org.glob3.mobile.generated.TimeInterval;
import org.glob3.mobile.generated.URLTemplateLayer;


public class BaseLayers {


   public static Layer createBaseLayerByName(final String name) {


      switch (name) {
         case "CartoDB light":
            return URLTemplateLayer.newMercator("http://s.basemaps.cartocdn.com/light_all/{level}/{x}/{y}.png", //URL
                     Sector.FULL_SPHERE,//SECTOR
                     false,//TRANSPARENCY
                     1, 18, TimeInterval.fromDays(30));
         case "CartoDB light without labels":
            return URLTemplateLayer.newMercator("http://s.basemaps.cartocdn.com/light_nolabels/{level}/{x}/{y}.png", //URL
                     Sector.FULL_SPHERE,//SECTOR
                     false,//TRANSPARENCY
                     1, 18, TimeInterval.fromDays(30));
         case "CartoDB without labels":
            return URLTemplateLayer.newMercator("http://s.basemaps.cartocdn.com/light_nolabels/{level}/{x}/{y}.png", //URL
                     Sector.FULL_SPHERE,//SECTOR
                     false,//TRANSPARENCY
                     1, 18, TimeInterval.fromDays(30));
         case "CartoDB dark":
            return URLTemplateLayer.newMercator("http://s.basemaps.cartocdn.com/dark_all/{level}/{x}/{y}.png", //URL
                     Sector.FULL_SPHERE,//SECTOR
                     false,//TRANSPARENCY
                     1, 18, TimeInterval.fromDays(30));
         case "CartoDB dark without labels":
            return URLTemplateLayer.newMercator("http://s.basemaps.cartocdn.com/dark_nolabels/{level}/{x}/{y}.png", //URL
                     Sector.FULL_SPHERE,//SECTOR
                     false,//TRANSPARENCY
                     1, 18, TimeInterval.fromDays(30));
         case "Open topo map":
            return URLTemplateLayer.newMercator("http://s.basemaps.cartocdn.com/dark_nolabels/{level}/{x}/{y}.png", //URL
                     Sector.FULL_SPHERE,//SECTOR
                     false,//TRANSPARENCY
                     1, 18, TimeInterval.fromDays(30));
         case "Stamen watercolor":
            return URLTemplateLayer.newMercator("http://c.tile.stamen.com/watercolor/{level}/{x}/{y}.jpg", //URL
                     Sector.FULL_SPHERE,//SECTOR
                     false,//TRANSPARENCY
                     1, 18, TimeInterval.fromDays(30));
         case "Stamen toner":
            return URLTemplateLayer.newMercator("http://c.tile.stamen.com/toner/{level}/{x}/{y}.jpg", //URL
                     Sector.FULL_SPHERE,//SECTOR
                     false,//TRANSPARENCY
                     1, 18, TimeInterval.fromDays(30));
         case "Stamen toner lite":
            return URLTemplateLayer.newMercator("http://c.tile.stamen.com/toner-lite/{level}/{x}/{y}.jpg", //URL
                     Sector.FULL_SPHERE,//SECTOR
                     false,//TRANSPARENCY
                     1, 18, TimeInterval.fromDays(30));
         case "OSM Mapnik":
            return new OSMLayer(TimeInterval.fromDays(30));
         case "MapQuest roads":
            return URLTemplateLayer.newMercator("http://ttiles01.mqcdn.com/tiles/1.0.0/vy/map/{level}/{x}/{y}.png", //URL
                     Sector.FULL_SPHERE,//SECTOR
                     false,//TRANSPARENCY
                     1, 18, TimeInterval.fromDays(30));
         case "MapQuest aerial":
            return URLTemplateLayer.newMercator("http://ttiles01.mqcdn.com/tiles/1.0.0/vy/sat/{level}/{x}/{y}.png", //URL
                     Sector.FULL_SPHERE,//SECTOR
                     false,//TRANSPARENCY
                     1, 18, TimeInterval.fromDays(30));
         case "ESRI world topo map":
            return URLTemplateLayer.newMercator(
                     "http://server.arcgisonline.com/ArcGIS/rest/services/World_Topo_Map/MapServer/tile/{level}/{y}/{x}.jpg", //URL
                     Sector.FULL_SPHERE,//SECTOR
                     false,//TRANSPARENCY
                     1, 18, TimeInterval.fromDays(30));
         case "ESRI world street map":
            return URLTemplateLayer.newMercator(
                     "http://server.arcgisonline.com/ArcGIS/rest/services/World_Street_Map/MapServer/tile/{level}/{y}/{x}.jpg", //URL
                     Sector.FULL_SPHERE,//SECTOR
                     false,//TRANSPARENCY
                     1, 18, TimeInterval.fromDays(30));
         case "ESRI DeLorme world map":
            return URLTemplateLayer.newMercator(
                     "http://server.arcgisonline.com/ArcGIS/rest/services/Specialty/DeLorme_World_Base_Map/MapServer/tile/{level}/{y}/{x}.jpg", //URL
                     Sector.FULL_SPHERE,//SECTOR
                     false,//TRANSPARENCY
                     1, 18, TimeInterval.fromDays(30));
         case "ESRI world imagery":
            return URLTemplateLayer.newMercator(
                     "http://server.arcgisonline.com/ArcGIS/rest/services/World_Imagery/MapServer/tile/{level}/{y}/{x}.jpg", //URL
                     Sector.FULL_SPHERE,//SECTOR
                     false,//TRANSPARENCY
                     1, 18, TimeInterval.fromDays(30));
         case "ESRI world terrain":
            return URLTemplateLayer.newMercator(
                     "http://server.arcgisonline.com/ArcGIS/rest/services/World_Imagery/MapServer/tile/{level}/{y}/{x}.jpg", //URL
                     Sector.FULL_SPHERE,//SECTOR
                     false,//TRANSPARENCY
                     1, 18, TimeInterval.fromDays(30));
         case "ESRI world shaded relief":
            return URLTemplateLayer.newMercator(
                     "http://server.arcgisonline.com/ArcGIS/rest/services/World_Shaded_Relief/MapServer/tile/{level}/{y}/{x}.jpg", //URL
                     Sector.FULL_SPHERE,//SECTOR
                     false,//TRANSPARENCY
                     1, 18, TimeInterval.fromDays(30));
         case "ESRI NatGeo world map":
            return URLTemplateLayer.newMercator(
                     "http://server.arcgisonline.com/ArcGIS/rest/services/NatGeo_World_Map/MapServer/tile/{level}/{y}/{x}.jpg", //URL
                     Sector.FULL_SPHERE,//SECTOR
                     false,//TRANSPARENCY
                     1, 18, TimeInterval.fromDays(30));
         case "MapQuest labels":
            return URLTemplateLayer.newMercator("http://ttiles01.mqcdn.com/tiles/1.0.0/vy/hyb/{level}/{x}/{y}.png", //URL
                     Sector.FULL_SPHERE,//SECTOR
                     false,//TRANSPARENCY
                     1, 18, TimeInterval.fromDays(30));
         case "Stamen toner hybrid":
            return URLTemplateLayer.newMercator("http://c.tile.stamen.com/toner-hybrid/{level}/{x}/{y}.jpg", //URL
                     Sector.FULL_SPHERE,//SECTOR
                     false,//TRANSPARENCY
                     1, 18, TimeInterval.fromDays(30));
         case "Stamen toner lines":
            return URLTemplateLayer.newMercator("http://c.tile.stamen.com/toner-lines/{level}/{x}/{y}.jpg", //URL
                     Sector.FULL_SPHERE,//SECTOR
                     false,//TRANSPARENCY
                     1, 18, TimeInterval.fromDays(30));
         case "Stamen toner labels":
            return URLTemplateLayer.newMercator("http://c.tile.stamen.com/toner-labels/{level}/{x}/{y}.jpg", //URL
                     Sector.FULL_SPHERE,//SECTOR
                     false,//TRANSPARENCY
                     1, 18, TimeInterval.fromDays(30));
         case "Hydda roads and labels":
            return URLTemplateLayer.newMercator("http://s.tile.openstreetmap.se/hydda/roads_and_labels/{level}/{x}/{y}.jpg", //URL
                     Sector.FULL_SPHERE,//SECTOR
                     false,//TRANSPARENCY
                     1, 18, TimeInterval.fromDays(30));
         case "OpenWeatherMap clouds":
            return URLTemplateLayer.newMercator("http://s.tile.openweathermap.org/map/clouds/{level}/{x}/{y}.jpg", //URL
                     Sector.FULL_SPHERE,//SECTOR
                     false,//TRANSPARENCY
                     1, 18, TimeInterval.fromDays(30));
         case "OpenWeatherMap temperature":
            return URLTemplateLayer.newMercator("http://s.tile.openweathermap.org/temp/clouds/{level}/{x}/{y}.jpg", //URL
                     Sector.FULL_SPHERE,//SECTOR
                     false,//TRANSPARENCY
                     1, 18, TimeInterval.fromDays(30));
         case "OpenWeatherMap wind":
            return URLTemplateLayer.newMercator("http://s.tile.openweathermap.org/temp/wind/{level}/{x}/{y}.jpg", //URL
                     Sector.FULL_SPHERE,//SECTOR
                     false,//TRANSPARENCY
                     1, 18, TimeInterval.fromDays(30));
         case "OpenWeatherMap press":
            return URLTemplateLayer.newMercator("http://s.tile.openweathermap.org/temp/pressure_cntr/{level}/{x}/{y}.jpg", //URL
                     Sector.FULL_SPHERE,//SECTOR
                     false,//TRANSPARENCY
                     1, 18, TimeInterval.fromDays(30));
         default:
            break;
      }
      return null;
   }
}
