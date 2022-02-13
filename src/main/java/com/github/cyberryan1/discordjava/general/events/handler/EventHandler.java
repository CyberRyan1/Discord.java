package com.github.cyberryan1.discordjava.general.events.handler;

import com.github.cyberryan1.discordjava.internal.classes.EventData;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class EventHandler {

    private static final List<EventListener> eventListeners = new ArrayList<>();

    public static void dispatchEvent( EventData data ) { // TODO needs testing
        for ( int index = eventListeners.size() - 1; index >= 0; index-- ) {
            EventListener listener = eventListeners.get( index );
            for ( Method method : listener.getClass().getMethods() ) {
                if ( method.isAnnotationPresent( EventMethod.class ) && method.getParameterTypes().length == 1 ) {
                    if ( method.getAnnotation( EventMethod.class ).value() == data.getEventType() ) {
                        if ( method.getParameterCount() == 1 && method.getParameterTypes()[0] == data.getEventType().classValue ) {
                            try {
                                Constructor<?> constr = data.getEventType().classValue.getConstructor( String.class );
                                method.invoke( listener, constr.newInstance( data.getDataString() ) );
                            } catch ( InvocationTargetException | IllegalAccessException
                                    | NoSuchMethodException | InstantiationException e ) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }
    }

    public static void addListener( EventListener listener ) { eventListeners.add( listener ); }

    public static boolean containsListener( EventListener listener ) { return eventListeners.contains( listener ); }

    public static void removeListener( EventListener listener ) { eventListeners.remove( listener ); }
}