package com.tokenautocomplete;

import java.io.Serializable;

/**
 * Simple container object for contact data
 * <p>
 * Created by mgod on 9/12/13.
 *
 * @author mgod
 */
class InputModel implements Serializable {
    private final String input;
    private final String formattedInput;

    InputModel(String input, String formattedInput) {
        this.input = input;
        this.formattedInput = formattedInput;
    }

    String getInput() {
        return input;
    }

    String getFormattedInput() {
        return formattedInput;
    }

    @Override
    public String toString() {
        return input;
    }
}
