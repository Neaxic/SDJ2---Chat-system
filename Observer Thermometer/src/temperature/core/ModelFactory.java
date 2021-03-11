package temperature.core;

import Radiator.Radiator;
import temperature.mediator.ClientModel;
import temperature.mediator.ClientModelManager;
import temperature.mediator.TemperatureModel;
import temperature.mediator.TemperatureModelManager;
import temperature.model.Temperature;

public class ModelFactory {

        //private TemperatureModel dataModel;
        private ClientModel dataModel;

        private Radiator r;

        public ClientModel getDataModel() {
            if(dataModel == null) {
                dataModel = new ClientModelManager();
            }
            return dataModel;
        }

    /*public TemperatureModel getDataModel() {
        if(dataModel == null) {
            dataModel = new TemperatureModelManager();
        }
        return dataModel;
    }*/

}