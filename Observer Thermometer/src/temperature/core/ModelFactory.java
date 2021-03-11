package temperature.core;

import Radiator.Radiator;
import temperature.mediator.TemperatureModel;
import temperature.mediator.TemperatureModelManager;
import temperature.model.Temperature;

public class ModelFactory {

        private TemperatureModel dataModel;
        private Radiator r;

        public TemperatureModel getDataModel() {
            if(dataModel == null) {
                dataModel = new TemperatureModelManager();
            }
            return dataModel;
        }

}