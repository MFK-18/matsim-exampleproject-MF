package org.matsim.project;

import org.matsim.api.core.v01.Scenario;
import org.matsim.core.config.Config;
import org.matsim.core.config.ConfigUtils;
import org.matsim.core.config.groups.StrategyConfigGroup;
import org.matsim.core.controler.Controler;
import org.matsim.core.controler.OutputDirectoryHierarchy;
import org.matsim.core.replanning.strategies.DefaultPlanStrategiesModule;
import org.matsim.core.scenario.ScenarioUtils;

public class RunMatsimTest {

    public static void main(String[] args) {

        Config config = ConfigUtils.loadConfig("scenarios/equil/config.xml");

        config.controler().setLastIteration(5);
        config.controler().setOverwriteFileSetting(OutputDirectoryHierarchy.OverwriteFileSetting.deleteDirectoryIfExists);


        config.strategy().clearStrategySettings();

        {
            StrategyConfigGroup.StrategySettings stratSets = new StrategyConfigGroup.StrategySettings();
            stratSets.setWeight(1.);
            stratSets.setStrategyName(DefaultPlanStrategiesModule.DefaultSelector.BestScore);
            config.strategy().addStrategySettings(stratSets);
        }

        {
            StrategyConfigGroup.StrategySettings stratSets = new StrategyConfigGroup.StrategySettings();
            stratSets.setWeight(1.);
            stratSets.setStrategyName(DefaultPlanStrategiesModule.DefaultStrategy.ReRoute);
            config.strategy().addStrategySettings(stratSets);
        }

        Scenario scenario = ScenarioUtils.loadScenario(config);
        Controler controler = new Controler(scenario);
        controler.run();
    }
}
