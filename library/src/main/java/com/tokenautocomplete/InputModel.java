package com.tokenautocomplete;

import java.io.Serializable;

/**
 * Simple container object for contact data
 * <p>
 * Created by mgod on 9/12/13.
 *
 * @author mgod
 */
public class InputModel implements Serializable {
    private final String input;
    private final String formattedInput;

    public InputModel(String input, String formattedInput) {
        this.input = input;
        this.formattedInput = formattedInput;
    }

    public String getInput() {
        return input;
    }

    public String getFormattedInput() {
        return formattedInput;
    }

    @Override
    public String toString() {
        return input;
    }
}
