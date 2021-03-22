package com.example.textstyling;

import android.text.SpannableString;

public class Model {
    SpannableString value;
    public Model(SpannableString value)
    {
        this.value=value;
    }
    public SpannableString getValue() {
        return value;
    }

    public void setValue(SpannableString value) {
        this.value = value;
    }
}
