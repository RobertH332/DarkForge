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

import uk.co.hexeption.darkforge.DarkForge;
import uk.co.hexeption.darkforge.font.MinecraftFontRenderer;

import java.awt.*;

/**
 * Created by Hexeption on 18/12/2016.
 */
public class FontManager {

    private static String fontName = "Comfortaa";

    public MinecraftFontRenderer hud = new MinecraftFontRenderer();

    public MinecraftFontRenderer arraylist = new MinecraftFontRenderer();

    public MinecraftFontRenderer mainMenu = new MinecraftFontRenderer();

    public MinecraftFontRenderer button = new MinecraftFontRenderer();

    public MinecraftFontRenderer buttonHoverd = new MinecraftFontRenderer();

    public MinecraftFontRenderer chat = new MinecraftFontRenderer();

    public MinecraftFontRenderer guiTitle = new MinecraftFontRenderer();

    public MinecraftFontRenderer clickGui = new MinecraftFontRenderer();

    public MinecraftFontRenderer huzuni = new MinecraftFontRenderer();

    public MinecraftFontRenderer hud_big = new MinecraftFontRenderer();

    public MinecraftFontRenderer hud_small = new MinecraftFontRenderer();


    public static String getFontName() {

        return fontName;
    }

    public static void setFontName(String fontName) {

        FontManager.fontName = fontName;
        DarkForge.INSTANCE.fontManager.Initialization();
    }

    public void Initialization() {

        hud.setFont(new Font(fontName, Font.PLAIN, 22), true);
        arraylist.setFont(new Font(fontName, Font.PLAIN, 18), true);
        mainMenu.setFont(new Font(fontName, Font.PLAIN, 50), true);
        button.setFont(new Font(fontName, Font.PLAIN, 22), true);
        buttonHoverd.setFont(new Font(fontName, Font.PLAIN, 25), true);
        chat.setFont(new Font("Verdana", Font.PLAIN, 18), true);
        guiTitle.setFont(new Font(fontName, Font.PLAIN, 17), true);
        clickGui.setFont(new Font(fontName, Font.PLAIN, 16), true);
        huzuni.setFont(new Font("Roboto Condensed", Font.PLAIN, 16), true);
        hud_big.setFont(new Font(fontName, Font.PLAIN, 40), true);
        hud_small.setFont(new Font(fontName, Font.PLAIN, 12), true);
    }
}
