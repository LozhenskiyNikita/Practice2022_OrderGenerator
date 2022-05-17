package com.lozhensky.OrderGenerator.project;

import com.github.javafaker.Faker;
import lombok.Data;
import lombok.Value;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Data
@Value
public class Order
{
    int orderId;
    String clientName;
    List<Prod> prodlist;
    String status;
    Order()
    {
        Faker faker = new Faker();
        Random random = new Random();

        orderId = random.nextInt();
        status = "New";
        prodlist = new ArrayList<>();
        int n = random.nextInt(5) + 1;
        for (int i = 0; i < n; i++) {
            Prod temp = new Prod();
            temp.name = faker.book().title();
            temp.id=Math.abs(temp.name.hashCode());
            temp.cost = random.nextInt(700) + 200;
            temp.quantity = random.nextInt(10) + 1;
            temp.sum = temp.cost * temp.quantity;
            prodlist.add(temp);
        }
        clientName = faker.name().fullName();
    }
}

/*@Data
@Value
public class Order {
    String item;
    Double amount;
}*/