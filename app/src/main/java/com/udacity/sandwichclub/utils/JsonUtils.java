package com.udacity.sandwichclub.utils;

import android.util.Log;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.LinkedList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) throws JSONException {

        // Create the root JSON Object
        JSONObject root = new JSONObject(json);

        // Create the Sandwich
        Sandwich sandwich = new Sandwich();

        // Get the name object
        JSONObject objName = root.getJSONObject("name");

        // Set the main name of the sandwich
        sandwich.setMainName(objName.getString("mainName"));

        JSONArray arrAlsoKnownAs = objName.getJSONArray("alsoKnownAs");
        List<String> alsoKnownAsNames = new LinkedList<>();

        // Get all the "also know as" names
        for (int i = 0; i < arrAlsoKnownAs.length(); i++) {
            alsoKnownAsNames.add(arrAlsoKnownAs.getString(i));
        }

        // Set the list of other known names of the sandwich
        sandwich.setAlsoKnownAs(alsoKnownAsNames);

        // Set the place of origin of the sandwich
        sandwich.setPlaceOfOrigin(root.getString("placeOfOrigin"));

        // Set the description of the sandwich
        sandwich.setDescription(root.getString("description"));

        // Set the image URL of the sandwich
        sandwich.setImage(root.getString("image"));

        JSONArray arrIngredients = root.getJSONArray("ingredients");
        List<String> ingredients = new LinkedList<>();

        // Get all the ingredients of the sandwich
        for (int i = 0; i < arrIngredients.length(); i++) {
            ingredients.add(arrIngredients.getString(i));
        }

        // Set the ingredients of the sandwich
        sandwich.setIngredients(ingredients);

        // Log the newly created sandwich
        Log.i("JsonUtils", sandwich.toString());

        return sandwich;
    }
}
