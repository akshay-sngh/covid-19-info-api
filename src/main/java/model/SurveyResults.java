package model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

/**
 * Stores the result of the survey conducted about how likely a person is
 * to attend a particular location during COVID.
 */
public class SurveyResults {
    @SerializedName(value = "health_care_facilities")
    String healthCareFacilities;
    @SerializedName(value = "performances_and_sporting_events")
    String performancesAndSportingEvents;
    @SerializedName(value = "schools")
    String schools;
    @SerializedName(value = "places_of_worship")
    String placesOfWorship;
    @SerializedName(value = "retail_shops")
    String retailShops;
    @SerializedName(value = "parks_and_beaches")
    String parksAndBeaches;
    @SerializedName(value = "restaurants")
    String restaurants;
    @SerializedName(value = "places_of_employment")
    String placesOfEmployment;

    @JsonProperty("health_care_facilities")
    public String getHealthCareFacilities() {
        return this.healthCareFacilities;
    }

    public void setHealthCareFacilities(String healthCareFacilities) {
        this.healthCareFacilities = healthCareFacilities;
    }

    @JsonProperty("performances_and_sporting_events")
    public String getPerformancesAndSportingEvents() {
        return this.performancesAndSportingEvents;
    }

    public void setPerformancesAndSportingEvents(String performancesAndSportingEvents) {
        this.performancesAndSportingEvents = performancesAndSportingEvents;
    }

    @JsonProperty("schools")
    public String getSchools() {
        return this.schools;
    }

    public void setSchools(String schools) {
        this.schools = schools;
    }

    @JsonProperty("places_of_worship")
    public String getPlacesOfWorship() {
        return this.placesOfWorship;
    }

    public void setPlacesOfWorship(String placesOfWorship) {
        this.placesOfWorship = placesOfWorship;
    }

    @JsonProperty("retail_shops")
    public String getRetailShops() {
        return this.retailShops;
    }

    public void setRetailShops(String retailShops) {
        this.retailShops = retailShops;
    }

    @JsonProperty("parks_and_beaches")
    public String getParksAndBeaches() {
        return this.parksAndBeaches;
    }

    public void setParksAndBeaches(String parksAndBeaches) {
        this.parksAndBeaches = parksAndBeaches;
    }

    @JsonProperty("restaurants")
    public String getRestaurants() {
        return this.restaurants;
    }

    public void setRestaurants(String restaurants) {
        this.restaurants = restaurants;
    }

    @JsonProperty("places_of_employment")
    public String getPlacesOfEmployment() {
        return this.placesOfEmployment;
    }

    public void setPlacesOfEmployment(String placesOfEmployment) {
        this.placesOfEmployment = placesOfEmployment;
    }
}
