package org.suleiman.DataJpaWithVertx.Verticles;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;
import io.vertx.core.json.Json;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.handler.BodyHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.suleiman.DataJpaWithVertx.Entity.Department;
import org.suleiman.DataJpaWithVertx.Services.DepartmentService;

import javax.annotation.PostConstruct;
import java.util.Random;
import java.util.UUID;

@Component
public class DepartmentVerticle extends AbstractVerticle {


    Logger logger = LoggerFactory.getLogger(DepartmentVerticle.class.getName());
    private int temperature = 21;
    UUID uuid = UUID.randomUUID();
    private final Random random = new Random();
    @Autowired
    DepartmentService departmentService;

    @Autowired
    Vertx vertx;


    @PostConstruct
    public void deploy() {
        vertx.deployVerticle(this);
    }

    @Override
    public void start(Promise<Void> startPromise) throws Exception {

       Router router = Router.router(vertx);
       router.get("/department").handler(this::getAllDepartments);
       router.get("/data").handler(this::getData);
       router.post("/department").consumes("*/json").handler(BodyHandler.create()).handler(this::saveDepartment);
       router.delete("/department").consumes("*/json").handler(BodyHandler.create()).handler(this::deleteDepartment);
       router.put("/department").consumes("*/json").handler(BodyHandler.create()).handler(this::updateDepartment);
       vertx.createHttpServer()
               .requestHandler(router)
               .listen(8080)
               .onSuccess(ok -> {
                   logger.info("http server running on 172.0.0.1:{}",8080);
                   startPromise.complete();
               })
               .onFailure(startPromise::fail);
    }


    private void saveDepartment(RoutingContext routingContext) {
        logger.info("Processing HTTP from {}",routingContext.request().remoteAddress());
        Department department = Json.decodeValue(routingContext.getBody(),Department.class);
        routingContext.response()
                .putHeader("Content-Type","application/json")
                .setChunked(true)
                .end(Json.encodePrettily(departmentService.addDepartment(department)));
    }

    private void updateDepartment(RoutingContext routingContext) {
        logger.info("Processing HTTP from {}",routingContext.request().remoteAddress());
        Department department = Json.decodeValue(routingContext.getBody(),Department.class);
        routingContext.response()
                .putHeader("Content-Type","application/json")
                .setChunked(true)
                .end(Json.encodePrettily(departmentService.updateDepartment(department)));
    }
    private void deleteDepartment(RoutingContext routingContext) {
        logger.info("Processing HTTP from {}",routingContext.request().remoteAddress());
        Department department = Json.decodeValue(routingContext.getBody(),Department.class);
        routingContext.response()
                .putHeader("Content-Type","application/json")
                .setChunked(true)
                .end(Json.encodePrettily(departmentService.deleteDepartment(department)));
    }
    private void getAllDepartments(RoutingContext routingContext) {
        logger.info("Processing HTTP from {}",routingContext.request().remoteAddress());
        routingContext.response()
                .putHeader("Content-Type","application/json")
                .setStatusCode(200)
                .setChunked(true)
                .end(Json.encodePrettily(departmentService.getAllDepartment()));
    }

    private void getData(RoutingContext routingContext) {
        logger.info("Processing HTTP from {}",routingContext.request().remoteAddress());
        JsonObject payload = new JsonObject();
        payload.put("Time_Stamp",System.currentTimeMillis());
        payload.put("Temperature",temperature);
        payload.put("UUID",uuid);
        routingContext.response()
                .putHeader("Content-Type","application/json")
                .setStatusCode(200)
                .end(Json.encodePrettily(payload));
    }

}
