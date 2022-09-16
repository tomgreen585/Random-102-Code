// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a COMP102/112 assignment.
// You may not distribute it in any other way without permission.

/* Code for COMP-102-112 - 2022T1, Assignment 1
 * Name: Thomas Green
 * Username: greenthom
 * ID: 300536064
 */
import java.util.*;
import ecs100.*;

/** Program for calculating carbon emissions */

public class CarbonEmissionsCalculator{

    public static final double EMISSION_FACTOR_POWER = 0.0977;   // emissions factor of electricity per kWh
    public static final double EMISSION_FACTOR_WASTE = 0.299;    // emissions factor of food waste per kg
    public static final double EMISSION_FACTOR_FUEL = 2.45; // emissions factor of petrol consumption per L

    public static final double ANNUAL_AVERAGE_POWER_EMISSION_NZ = 266.5;   //Annual average electrical carbon emissions in NZ (kg) from electricity use
    public static final double ANNUAL_AVERAGE_FOOD_WASTE_EMISSION_NZ = 18; //Annual average waste carbon emissions in NZ (kg) from food waste
    
    public static void userInput() {
   
    }
    /**
     * Calculates and prints carbon emissions
     */
    public void calculateEmissions (){
        
        double foodWastagePerMonth = UI.askDouble("What is your weekly food wastage? (kg)");
        double electricityConsumptionPerMonth = UI.askDouble("What is your monthly electricity usage? (kwh)");
        
        double foodWasteEmissionsPerWeek = (EMMISSION_FACTOR_WASTE * foodWastagePerMonth) *52;
        double electricityEmissionsPerMonth = (EMISSION_FACTOR_POWER * electricityConsumptionPerMonth) *12;
        double annualAverageCarbonEmissionsNZ = (EMISSION_FACTOR_POWER_EMISSIION_NZ * ANNUAL_AVERAGE_FOOD_WASTE_EMISSION_NZ);
        
        
        
        

    double electricityConsumptionPerMonth = UI.askDouble("Monthly electricity consumption (kwh): "); //ask uer for monthly electricity consumption per kwh
    double foodWastePerWeek = UI.askDouble("What is your weekly food wastage? (kg): "); //ask user for weekly food waste per kg
    double petrolConsumptionPerWeek = UI.askDouble("What is your weekly fuel consumption (L): "); //ask user for weekly fuel consumption per L
    double individualsPerHousehold = UI.askDouble ("How many individuals live in your residence; ");
    
    double electricityConsumptionPerMonth = (electricityConsumptionPerMonth * EMISSION_FACTOR_POWER) * 12;
    double foodWastePerWeek = (foodWastePerWeek * EMISSION_FACTOR_WASTE) * 52;
    double petrolConsumptionPerWeek = (petrolConsumptionPerWeek * EMISSION_FACTOR_FUEL) * 52;
    double total = (electricityConsumptionPerMonth + foodWastePerWeek + petrolConsumptionPerWeek); 
        
        UI.println();
        UI.printf("Total emissions (anually, kg CO2-e): %.2f", total); 
        UI.println("");
        UI.printf("Total emissions (daily, kg CO@-e): %.2f", (total/365));  
        UI.println("");
    }

    public void calculateAverages (){
        double electricityConsumptionPerMonth = (electricityConsumptionPerMonth * EMISSION_FACTOR_POWER) * 12;
        double foodWastePerWeek = (foodWastePerWeek * EMISSION_FACTOR_WASTE) * 52;
        
        double averageElectricalConsumptionNZ = (electricityConsumptionPerMonth/ANNUAL_AVERAGE_POWER_EMISSION_NZ) * 100;
        double averageFoodWastePerWeekNZ = (foodWastePerWeek/ANNUAL_AVERAGE_FOOD_WASTE_EMISSION_NZ) * 100;
        
        UI.println("");
        if (foodWastePerWeek > ANNUAL_AVERAGE_FOOD_WASTE_EMISSION_NZ) {
            UI.printf("Your food waste carbon emission is %.2f percent of NZ's average food waste footprint.", averageFoodWastePerWeekNZ);
        }
        else if (foodWastePerWeek < ANNUAL_AVERAGE_FOOD_WASTE_EMISSION_NZ) {
            UI.printf("Your food waste carbon emission is %.2f percent of NZ's average food waste footprint.", averageFoodWastePerWeekNZ);
        }
        UI.println("");
        if (electricityConsumptionPerMonth > ANNUAL_AVERAGE_POWER_EMISSION_NZ) {
            UI.printf("Your power consumption emissions are %.2f percent of NZ's average power consumption footprint.", averageElectricalConsumptionNZ);
        }
        else if (electricityConsumptionPerMonth < ANNUAL_AVERAGE_POWER_EMISSION_NZ) {
            UI.printf("Your power consumption emissions are %.2f percent of NZ's average power consumption footprint.", averageElectricalConsumptionNZ);
            }
    }
    public void setupGUI(){
        UI.initialise();
        UI.addButton("Calculate Emissions", this::calculateEmissions);
        UI.addButton("Calculate Averages", this::calculateAverages);
        UI.addButton("Quit", UI::quit);
        UI.addButton("Restart", UI::quit);
        UI.setDivider(1);    // Expand the Text pane
    }

    public static void main(String[] args){
        CarbonEmissionsCalculator cec = new CarbonEmissionsCalculator();
        cec.setupGUI();
    }

}
