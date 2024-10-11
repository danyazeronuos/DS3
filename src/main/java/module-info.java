module org.zero.ds3 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires spring.core;
    requires spring.beans;
    requires spring.aop;
    requires spring.context;
    requires static lombok;
    requires org.slf4j;
    requires spring.tx;
    requires spring.data.jpa;
    requires jakarta.persistence;
    requires spring.orm;
    requires spring.jdbc;
    requires org.hibernate.orm.core;
    requires jakarta.annotation;

    opens org.zero.ds3 to javafx.fxml, org.slf4j;
    opens org.zero.ds3.config to spring.core, spring.beans, spring.context; // Allow Spring to access the config package
    opens org.zero.ds3.utils to spring.core, spring.beans, spring.context; // Allow Spring to access the config package
    opens org.zero.ds3.controller to javafx.fxml, spring.core, spring.beans, spring.context; // Allow Spring to access the config package
    opens org.zero.ds3.service to spring.core, spring.beans, spring.context; // Allow Spring to access the config package
    opens org.zero.ds3.repository to spring.core, spring.beans, spring.context, spring.data.jpa, spring.orm, spring.jdbc; // Allow Spring to access the config package
    opens org.zero.ds3.entity to spring.core, org.hibernate.orm.core, jakarta.persistence, spring.orm, spring.context, spring.data.jpa, spring.jdbc;
    exports org.zero.ds3;
    exports org.zero.ds3.utils;
    exports org.zero.ds3.entity;
    exports org.zero.ds3.repository;
    exports org.zero.ds3.controller;
}
