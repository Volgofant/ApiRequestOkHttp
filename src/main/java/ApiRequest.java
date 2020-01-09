import okhttp3.*;

import java.io.IOException;

class ApiRequest {
    ApiRequest(String sku, Integer quantity) throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "[\n    {\n\t    \"sku\": \"" + sku + "\",\n        \"stockType\": \"virtualShopStock\",\n        \"location\": null,\n        \"quality\": 1,\n        \"quantity\": \"" + quantity + "\"\n    }\n]\t");
        Request request = new Request.Builder()
                .url("http://192.168.49.127/api/v1/stock/quantity")
                .method("PUT", body)
                .addHeader("Content-Type", "application/json")
                .addHeader("auth-token", "shop-stage-C32B")
                .addHeader("user", "Shop Amind")
                .build();
        Response response = client.newCall(request).execute();
            System.out.println(response);
    }
}
