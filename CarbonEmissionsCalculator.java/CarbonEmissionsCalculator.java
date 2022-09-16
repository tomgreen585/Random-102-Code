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
        double electricityConsumptionPerMonth = UI.askDouble("Monthly electricity consumption (kwh): "); //ask uer for monthly electricity consumption per kwh
        double foodWastePerWeek = UI.askDouble("What is your weekly food wastage? (kg): "); //ask user for weekly food waste per kg
        double petrolConsumptionPerWeek = UI.askDouble("What is your weekly fuel consumption (L): "); //ask user for weekly fuel consumption per L
        double individualsPerHousehold = UI.askDouble ("How many individuals live in your residence; ");
    }
/** 
 * Calculates and print carbon emissions
 */
    public void calculateEmissions (double electricityConsumptionPerMonth, double foodWastePerWeek, double petrolConsumptionPerWeek){
        /*# YOUR CODE HERE */
        
        double electricityConsumptionPerMonth_calc = (electricityConsumptionPerMonth * EMISSION_FACTOR_POWER) * 12;
        double foodWasteEmissionsPerWeek_calc = (foodWastePerWeek * EMISSION_FACTOR_WASTE) * 52;
        double petrolConsumptionPerWeek_calc = (petrolConsumptionPerWeek * EMISSION_FACTOR_FUEL) * 52;
        
        double total = (electricityConsumptionPerMonth_calc + foodWasteEmissionsPerWeek_calc + petrolConsumptionPerWeek); 
        
        UI.println();
        UI.printf("Total emissions (anually, kg CO2-e): %.2f", total); 
        UI.println("");
        UI.printf("Total emissions (daily, kg CO@-e): %.2f", (total/365));  
        UI.println("");
    }
/**
 * calculate and print carbon emissions to NZ average
 */
    public void calculateAverages (double electricityConsumptionPerMonth, double foodWastePerWeek){
        double electricityConsumptionPerMonth_calc = (electricityConsumptionPerMonth * EMISSION_FACTOR_POWER) * 12;
        double foodWastePerWeek_calc = (foodWastePerWeek * EMISSION_FACTOR_WASTE) * 52;
        
        double averageElectricalConsumptionNZ = (electricityConsumptionPerMonth_calc/ANNUAL_AVERAGE_POWER_EMISSION_NZ) * 100;
        double averageFoodWastePerWeekNZ = (foodWastePerWeek_calc/ANNUAL_AVERAGE_FOOD_WASTE_EMISSION_NZ) * 100;
        
        UI.println("");
        if (foodWastePerWeek_calc > ANNUAL_AVERAGE_FOOD_WASTE_EMISSION_NZ) {
            UI.printf("Your food waste carbon emission is %.2f percent of NZ's average food waste footprint.", averageFoodWastePerWeekNZ);
        }
        else if (foodWastePerWeek_calc < ANNUAL_AVERAGE_FOOD_WASTE_EMISSION_NZ) {
            UI.printf("Your food waste carbon emission is %.2f percent of NZ's average food waste footprint.", averageFoodWastePerWeekNZ);
        }
        UI.println("");
        if (electricityConsumptionPerMonth_calc > ANNUAL_AVERAGE_POWER_EMISSION_NZ) {
            UI.printf("Your power consumption emissions are %.2f percent of NZ's average power consumption footprint.", averageElectricalConsumptionNZ);
        }
        else if (electricityConsumptionPerMonth_calc < ANNUAL_AVERAGE_POWER_EMISSION_NZ) {
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
