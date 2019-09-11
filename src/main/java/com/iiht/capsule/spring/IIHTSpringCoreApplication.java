package com.iiht.spring;

import com.iiht.spring.context.ApplicationConfiguration;
import com.iiht.spring.operations.OperationMenu;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.io.IOException;

public class IIHTSpringCoreApplication {
    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(ApplicationConfiguration.class);
        context.refresh();
        OperationMenu operationMenu = context.getBean(OperationMenu.class);
        operationMenu.displayMenu();
    }
}
