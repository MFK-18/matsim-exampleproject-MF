package org.matsim.project;

import org.matsim.api.core.v01.Scenario;
import org.matsim.core.config.Config;
import org.matsim.core.config.ConfigUtils;
import org.matsim.core.controler.Controler;
import org.matsim.core.controler.OutputDirectoryHierarchy;
import org.matsim.core.scenario.ScenarioUtils;

public class RunMatsim11052020 {

    public static void main(String[] args) {

        Config config = ConfigUtils.loadConfig("scenarios/equil/config.xml");

        config.controler().setOverwriteFileSetting(OutputDirectoryHierarchy.OverwriteFileSetting.deleteDirectoryIfExists);
        config.controler().setLastIteration(5);

        //  config.qsim().setFlowCapFactor(0.5);
        //  config.qsim().setStorageCapFactor(0.5);

       Scenario scenario = ScenarioUtils.loadScenario(config);
       Controler controler = new Controler(scenario);
       controler.run();
    }
}
