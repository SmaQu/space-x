package com.alastor.spacex;

import com.alastor.spacex.model.Capsule;
import com.alastor.spacex.model.Company;
import com.alastor.spacex.model.Core;
import com.alastor.spacex.model.Crew;
import com.alastor.spacex.model.Dragon;
import com.alastor.spacex.model.Landpad;
import com.alastor.spacex.model.Launch;
import com.alastor.spacex.model.Launchpad;
import com.alastor.spacex.model.Payload;
import com.alastor.spacex.model.Roadster;
import com.alastor.spacex.model.Rocket;
import com.alastor.spacex.model.Ship;
import com.alastor.spacex.model.Starlink;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface SpaceXService {

    @GET("/capsules")
    Single<List<Capsule>> getCapsules();

    @GET("/capsules/{id}")
    Single<Capsule> getCapsule(@Path("id") long id);

    @GET("/company")
    Single<Company> getCompanyInfo();

    @GET("/cores")
    Single<List<Core>> getCores();

    @GET("/cores/{id}")
    Single<Core> getCore(@Path("id") long id);

    @GET("/crew")
    Single<List<Crew>> getCrews();

    @GET("/crew/{id}")
    Single<Crew> getCrew(@Path("id") long id);

    @GET("/dragons")
    Single<List<Dragon>> getDragons();

    @GET("/dragons/{id}")
    Single<Dragon> getDragon(@Path("id") long id);

    @GET("/landpads")
    Single<List<Landpad>> getLandpads();

    @GET("/landpads/{id}")
    Single<Landpad> getLandpad(@Path("id") long id);

    @GET("/launches/past")
    Single<List<Launch>> getPastLaunches();

    @GET("/launches/upcoming")
    Single<Launch> getUpcomingLaunches();

    @GET("/launches/latest")
    Single<Launch> getLatestLaunch();

    @GET("/launches/next")
    Single<Launch> getNextLaunch();

    @GET("/launches")
    Single<List<Launch>> getAllLaunches();

    @GET("/launches/{id}")
    Single<Landpad> getLaunch(@Path("id") long id);

    @GET("/launchpads")
    Single<List<Launchpad>> getLaunchPads();

    @GET("/launchpads/{id}")
    Single<Launchpad> getLaunchPad(@Path("id") long id);

    @GET("/payloads")
    Single<List<Payload>> getPayLoads();

    @GET("/payloads/{id}")
    Single<Payload> getPayLoad(@Path("id") long id);

    @GET("/roadster")
    Single<List<Roadster>> getRoadster();

    @GET("/rockets")
    Single<List<Rocket>> getRockets();

    @GET("/rockets/{id}")
    Single<Rocket> getRocket(@Path("id") long id);

    @GET("/ships")
    Single<List<Ship>> getShips();

    @GET("/ships/{id}")
    Single<Ship> getShip(@Path("id") long id);

    @GET("/starlink")
    Single<List<Starlink>> getStarlinks();

    @GET("/starlink/{id}")
    Single<Starlink> getStarlink(@Path("id") long id);

}