

package com.glob3mobile.g3m.qgis.model;


public class VectorLayerData
         extends
            LayerData {

   private String _path;
   private String _stylePath;


   public String getPath() {
      return _path;
   }


   public void setPath(final String path) {
      _path = path;
   }


   public String getStylePath() {
      return _stylePath;
   }


   public void setStylePath(final String stylePath) {
      _stylePath = stylePath;
   }


}
