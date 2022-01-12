package model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

/**
 * Response schema to be sent back to the Android app
 */
public class Entry {
    @SerializedName(value = "effective_sample_size")
    double effectiveSampleSize;
    @SerializedName(value = "survey_results")
    SurveyResults surveyResults;

    @JsonProperty("effective_sample_size")
    public double getEffectiveSampleSize() {
        return this.effectiveSampleSize;
    }

    public void setEffectiveSampleSize(double effectiveSampleSize) {
        this.effectiveSampleSize = effectiveSampleSize;
    }

    @JsonProperty("survey_results")
    public SurveyResults getSurveyResults() {
        return this.surveyResults;
    }

    public void setSurveyResults(SurveyResults surveyResults) {
        this.surveyResults = surveyResults;
    }
}

