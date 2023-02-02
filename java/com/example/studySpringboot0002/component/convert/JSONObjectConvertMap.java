//package com.example.studySpringboot0002.component.convert;
//
//public class JSONObjectConvertMap {
//
//    /**
//     * @param Map<String, Object>
//     * @apiNote Map<String, Object>를 JSONObject로 변환처리.
//     * @return JSONObject
//     * **/
//    public JSONObject convertMapToJson(Map<String, Object> map) {
//
//        JSONObject json = new JSONObject();
//        String key = "";
//        Object value = null;
//        for(Map.Entry<String, Object> entry : map.entrySet()) {
//            key = entry.getKey();
//            value = entry.getValue();
//            json.put(key, value);
//        }
//        return json;
//    }
//
//    /**
//     * @param JSONObject
//     * @apiNote JSONObject를 Map<String, String> 형식으로 변환처리.
//     * @return Map<String,String>
//     * **/
//    public static Map<String, Object> getMapFromJsonObject(JSONObject jsonObj){
//        Map<String, Object> map = null;
//
//        try {
//            map = new ObjectMapper().readValue(jsonObj.toString(), Map.class);
//        } catch (JsonParseException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } catch (JsonMappingException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//        return map;
//    }
//
//}
