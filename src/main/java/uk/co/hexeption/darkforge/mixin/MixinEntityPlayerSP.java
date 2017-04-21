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
package uk.co.hexeption.darkforge.mixin;

import net.minecraft.client.entity.EntityPlayerSP;
import org.spongepowered.asm.lib.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import uk.co.hexeption.darkforge.event.Event;
import uk.co.hexeption.darkforge.event.events.EventChat;
import uk.co.hexeption.darkforge.event.events.EventPlayerSlowDown;
import uk.co.hexeption.darkforge.managers.EventManager;

/**
 * Created by Keir on 21/04/2017.
 */
@Mixin(EntityPlayerSP.class)
public abstract class MixinEntityPlayerSP {

    @Inject(method = "onLivingUpdate", at = @At(value = "FIELD", opcode = Opcodes.PUTFIELD, target = "Lnet/minecraft/client/entity/EntityPlayerSP;sprintToggleTimer:I", ordinal = 1, shift = At.Shift.AFTER), cancellable = true)
    public void IonLivingUpdate(CallbackInfo callback) {
        EventPlayerSlowDown event = new EventPlayerSlowDown(Event.Type.POST, (EntityPlayerSP) (Object) this);
        EventManager.handleEvent(event);
        if (event.isCancelled()) {
            callback.cancel();
        }
    }

    @Inject(method = "sendChatMessage", at = @At("HEAD"), cancellable = true)
    public void IsendChatMessage(String message, CallbackInfo callback) {
        EventChat.Send event = new EventChat.Send(Event.Type.PRE, (EntityPlayerSP) (Object) this, message);
        EventManager.handleEvent(event);
        if (event.isCancelled()) {
            callback.cancel();
        }
    }
}
