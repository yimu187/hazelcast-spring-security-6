//package com.proto.hazelcastsql;
//
//import com.hazelcast.config.Config;
//import com.hazelcast.core.Hazelcast;
//import com.hazelcast.core.HazelcastInstance;
//import com.hazelcast.sql.SqlResult;
//import com.hazelcast.sql.SqlRow;
//import com.hazelcast.sql.SqlService;
//import org.springframework.boot.context.event.ApplicationStartedEvent;
//import org.springframework.context.ApplicationListener;
//import org.springframework.stereotype.Component;
//
//@Component
//public class OnStartup  implements ApplicationListener<ApplicationStartedEvent> {
//
//    @Override
//    public void onApplicationEvent(ApplicationStartedEvent event) {
//
//
//        Config helloWorldConfig = new Config();
//        helloWorldConfig.setClusterName("hello-world");
//        helloWorldConfig.getJetConfig().setEnabled(true);
//
//        HazelcastInstance hz = Hazelcast.newHazelcastInstance(helloWorldConfig);
//        //HazelcastInstance hz2 = Hazelcast.newHazelcastInstance(helloWorldConfig);
//        //HazelcastInstance hz3 = Hazelcast.newHazelcastInstance(helloWorldConfig)
//
//
//
//        String createMappingQuery = "CREATE MAPPING cities\n" +
//                "(__key INT,\n" +
//                "countries VARCHAR,\n" +
//                "cities VARCHAR) "
//                + "TYPE IMap\n"
//                + "OPTIONS ('keyFormat'='int','valueFormat'='json-flat')";
//
//        SqlService sql = hz.getSql();
//        sql.execute(createMappingQuery);
//
//        String insertStr = "INSERT INTO cities VALUES\n" +
//                "(1, 'United Kingdom','London'),\n" +
//                "(2, 'United Kingdom','Manchester'),\n" +
//                "(3, 'United States', 'New York'),\n" +
//                "(4, 'United States', 'Los Angeles'),\n" +
//                "(5, 'Turkey', 'Ankara'),\n" +
//                "(6, 'Turkey', 'Istanbul'),\n" +
//                "(7, 'Brazil', 'Sao Paulo'),\n" +
//                "(8, 'Brazil', 'Rio de Janeiro');";
//        sql.execute(insertStr);
//
//        String scanQuery = "SELECT * FROM cities";
//        SqlResult result = sql.execute(scanQuery);
//        showResult(result);
//
//        String createPopulationDDLQuery = "REATE MAPPING population2020 (\n" +
//                "__key INT,\n" +
//                "cities VARCHAR,\n" +
//                "population INT)\n" +
//                "TYPE IMap OPTIONS ('keyFormat'='int', 'valueFormat'='json-flat');";
//
//        sql.execute(createPopulationDDLQuery);
//
//        String insertPopQuery = "INSERT INTO population2020 VALUES\n" +
//                "(1, 'London', 9304016),\n" +
//                "(2, 'Manchester', 2730076),\n" +
//                "(3, 'New York', 8622357),\n" +
//                "(4, 'Los Angeles', 4085014),\n" +
//                "(5, 'Sao Paulo', 12396372),\n" +
//                "(6, 'Rio de Janeiro', 6775561),\n" +
//                "(7, 'Istanbul', 14804116),\n" +
//                "(8, 'Ankara', 3517182);";
//        sql.execute(insertPopQuery);
//
//        String popScanQuery = "SELECT * FROM population2020";
//        SqlResult popResult = sql.execute(popScanQuery);
//        showResult(popResult);
//
//
////        IMap<String, String> map = hz.getMap("my-distributed-map");
////        map.put("1", "John");
////        map.put("2", "Mary");
////        map.put("3", "Jane");
////
////        System.out.println(map.get("1"));
////        System.out.println(map.get("2"));
////        System.out.println(map.get("3"));
////
////
////
////        SqlService sql = hz.getSql();
////
////        String createMappingQuery = "CREATE MAPPING myDistributedMap2\n"
////                + "TYPE IMap\n"
////                + "OPTIONS ('keyFormat'='varchar','valueFormat'='varchar')";
////        sql.execute(createMappingQuery);
////
////        List<String> insertionQueries = Arrays.asList(
////                "SINK INTO myDistributedMap2 VALUES('1', 'Berkay')",
////                "SINK INTO myDistributedMap2 VALUES('2', 'Murat')",
////                "SINK INTO myDistributedMap2 VALUES('3', 'Keskin')"
////        );
////        for (String insertionQuery : insertionQueries) {
////            sql.execute(insertionQuery);
////        }
////
////        String scanQuery = "SELECT * FROM myDistributedMap2";
////        try (SqlResult result = sql.execute(scanQuery)) {
////        showResult(result);
////        }
////
////        IMap<String, String> map2 = hz.getMap("myDistributedMap2");
////        System.out.println(map2.get("1"));
////        System.out.println(map2.get("2"));
////        System.out.println(map2.get("3"));
//    }
//
//    private void showResult(SqlResult result) {
//        int columnCount = result.getRowMetadata().getColumnCount();
//        for (SqlRow row : result) {
//            for (int colIdx = 0; colIdx < columnCount; colIdx++) {
//                System.out.print(row.getObject(colIdx) + " ");
//            }
//            System.out.println();
//        }
//    }
//}
