package dev.dani.bobabestiary.repository;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import dev.dani.bobabestiary.dto.DrinkSummaryResponse;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.QueryRequest;

@Repository
public class BobaBestiaryRepository {
    private final DynamoDbClient dynamoDbClient;
    private final String tableName;

    public BobaBestiaryRepository(
            DynamoDbClient dynamoDbClient,
            @Value("${boba.dynamodb.table-name}") String tableName
    ) {
        this.dynamoDbClient = dynamoDbClient;
        this.tableName = tableName;
    }

    public List<DrinkSummaryResponse> findDrinkSummariesByShopId(String shopId) {
        QueryRequest request = QueryRequest.builder()
                .tableName(tableName)
                .keyConditionExpression("PK = :pk AND begins_with(SK, :skPrefix)")
                .expressionAttributeValues(Map.of(
                        ":pk", AttributeValue.fromS("SHOP#" + shopId),
                        ":skPrefix", AttributeValue.fromS("DRINK#")
                ))
                .build();

        return dynamoDbClient.query(request)
                .items()
                .stream()
                .map(this::toDrinkSummaryResponse)
                .toList();
    }

    private DrinkSummaryResponse toDrinkSummaryResponse(Map<String, AttributeValue> item) {
        return new DrinkSummaryResponse(
                item.get("drinkId").s(),
                item.get("name").s(),
                item.get("species").s(),
                item.get("baseFlavor").s(),
                item.get("summonAgain").bool(),
                Integer.parseInt(item.get("rating").n()),
                Integer.parseInt(item.get("calorieEstimate").n())
        );
    }
}
