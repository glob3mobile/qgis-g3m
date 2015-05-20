

package com.glob3mobile.g3m.qgis.parser;

import com.globl3mobile.g3m.qgis.model.Scenario;


public interface ScenarioLoaderListener {

   void onError(final String message);


   void onScenarioRead(Scenario scenario);
}
