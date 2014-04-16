package pt.isel.mpd14.utestfw;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Expect {
	Class<? extends Exception> value();
}
