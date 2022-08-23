package org.suleiman.DataJpaWithVertx.Verticles;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Handler;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;
import io.vertx.core.json.Json;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.handler.BodyHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.suleiman.DataJpaWithVertx.Entity.Staff;
import org.suleiman.DataJpaWithVertx.Services.StaffService;

import javax.annotation.PostConstruct;

@Component
public class StaffVerticle extends AbstractVerticle {

    Logger logger = LoggerFactory.getLogger(StaffVerticle.class.getName());

    @Autowired
    Vertx vertx;

    @Autowired
    StaffService staffService;

    @PostConstruct
    void deploy() {
        vertx.deployVerticle(this);
    }

    @Override
    public void start(Promise<Void> startPromise) throws Exception {
        Router router = Router.router(vertx);
        router.get("/staff").handler(this::getStaffs);
        router.post("/staff").consumes("*/json").handler(BodyHandler.create()).handler(this::addStaff);
        router.delete("/staff").consumes("*/json").handler(BodyHandler.create()).handler(this::deleteStaff);
        router.put("/staff").consumes("*/json").handler(this::updateStaff);


        vertx.createHttpServer().requestHandler(router).listen(9090)
                .onSuccess(r -> {
                    logger.info("the HTTP server is running on {}",9090);
                    startPromise.complete();
                })
                .onFailure(r -> {
                    logger.error("some kind of error has occurred on {}",8080);
                    startPromise.fail("start has failed");
                });

    }



    private void addStaff(RoutingContext routingContext) {
        logger.info("Processing HTTP from {}",routingContext.request().remoteAddress());
        Staff staff = Json.decodeValue(routingContext.getBody(),Staff.class);
        routingContext.response()
                .putHeader("Content-Type","application/json")
                .setChunked(true)
                .setStatusCode(201)
                .end(Json.encodePrettily(staffService.addStaff(staff)));

    }

    private void updateStaff(RoutingContext routingContext) {
        logger.info("Processing HTTP from {}",routingContext.request().remoteAddress());
        Staff staff = Json.decodeValue(routingContext.getBody(),Staff.class);
        routingContext.response()
                .putHeader("Content-Type","application/json")
                .setChunked(true)
                .setStatusCode(201)
                .end(Json.encodePrettily(staffService.updateStaff(staff)));
    }

    private void deleteStaff(RoutingContext routingContext) {
        logger.info("Processing HTTP from {}",routingContext.request().remoteAddress());
        Staff staff = Json.decodeValue(routingContext.getBody(),Staff.class);
        routingContext.response()
                .putHeader("Content-Type","application/json")
                .setChunked(true)
                .setStatusCode(201)
                .end(Json.encodePrettily(staffService.deleteStaff(staff)));
    }

    private void getStaffs(RoutingContext routingContext) {
        logger.info("Processing HTTP from {}",routingContext.request().remoteAddress());
        routingContext.response()
                .putHeader("Content-Type","application/json")
                .setChunked(true)
                .setStatusCode(200)
                .end(Json.encodePrettily(staffService.getAllStaff()));
        logger.info("All the staff have successfully been retrieved from the database{}",routingContext.request().remoteAddress());
    }

}
