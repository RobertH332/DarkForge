/*******************************************************************************
 *     DarkForge a Forge Hacked Client
 *     Copyright (C) 2017  Hexeption (Keir Davis)
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <http://www.gnu.org/licenses/>.
 ******************************************************************************/
package uk.co.hexeption.darkforge.managers;

import com.google.common.collect.Lists;
import uk.co.hexeption.darkforge.event.Event;
import uk.co.hexeption.darkforge.event.EventListener;

import java.util.Comparator;
import java.util.List;

/**
 * Created by Keir on 21/04/2017.
 */
public class EventManager {

    private static final List<EventListener> LISTENERS = Lists.newCopyOnWriteArrayList();

    public static void register(EventListener listener) {
        LISTENERS.add(listener);
        LISTENERS.sort(Comparator.comparing(EventListener::getPriority));
    }

    public static void handleEvent(Event event) {
        for (EventListener listener : LISTENERS) {
            listener.onEvent(event);
        }
    }
}