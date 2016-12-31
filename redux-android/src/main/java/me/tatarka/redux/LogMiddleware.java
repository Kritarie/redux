package me.tatarka.redux;

import android.util.Log;
import me.tatarka.redux.middleware.Middleware;

public class LogMiddleware<A, R> implements Middleware<A, R> {

    private final String tag;
    private final int priority;

    public LogMiddleware(String tag) {
        this(tag, Log.DEBUG);
    }

    public LogMiddleware(String tag, int priority) {
        this.tag = tag;
        this.priority = priority;
    }

    @Override
    public R dispatch(Next<A, R> next, A action) {
        Log.println(priority, tag, action.toString());
        return next.next(action);
    }
}
