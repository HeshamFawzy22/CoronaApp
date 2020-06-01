
package com.example.egyptnews.model;


import com.google.gson.annotations.Expose;

@SuppressWarnings("unused")
public class NewsResponse {

    @Expose
    private Long active;
    @Expose
    private Long cases;
    @Expose
    private Long casesPerOneMillion;
    @Expose
    private String country;
    @Expose
    private Long critical;
    @Expose
    private Long deaths;
    @Expose
    private Long deathsPerOneMillion;
    @Expose
    private Long recovered;
    @Expose
    private Long testsPerOneMillion;
    @Expose
    private Long todayCases;
    @Expose
    private Long todayDeaths;
    @Expose
    private Long totalTests;

    public Long getActive() {
        return active;
    }

    public void setActive(Long active) {
        this.active = active;
    }

    public Long getCases() {
        return cases;
    }

    public void setCases(Long cases) {
        this.cases = cases;
    }

    public Long getCasesPerOneMillion() {
        return casesPerOneMillion;
    }

    public void setCasesPerOneMillion(Long casesPerOneMillion) {
        this.casesPerOneMillion = casesPerOneMillion;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Long getCritical() {
        return critical;
    }

    public void setCritical(Long critical) {
        this.critical = critical;
    }

    public Long getDeaths() {
        return deaths;
    }

    public void setDeaths(Long deaths) {
        this.deaths = deaths;
    }

    public Long getDeathsPerOneMillion() {
        return deathsPerOneMillion;
    }

    public void setDeathsPerOneMillion(Long deathsPerOneMillion) {
        this.deathsPerOneMillion = deathsPerOneMillion;
    }

    public Long getRecovered() {
        return recovered;
    }

    public void setRecovered(Long recovered) {
        this.recovered = recovered;
    }

    public Long getTestsPerOneMillion() {
        return testsPerOneMillion;
    }

    public void setTestsPerOneMillion(Long testsPerOneMillion) {
        this.testsPerOneMillion = testsPerOneMillion;
    }

    public Long getTodayCases() {
        return todayCases;
    }

    public void setTodayCases(Long todayCases) {
        this.todayCases = todayCases;
    }

    public Long getTodayDeaths() {
        return todayDeaths;
    }

    public void setTodayDeaths(Long todayDeaths) {
        this.todayDeaths = todayDeaths;
    }

    public Long getTotalTests() {
        return totalTests;
    }

    public void setTotalTests(Long totalTests) {
        this.totalTests = totalTests;
    }

}
