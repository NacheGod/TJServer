/*
 * This file is part of TJServer.
 * 
 * TJServer is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * TJServer is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package tera.gameserver.model.quests;

import tera.gameserver.model.npc.Npc;
import tera.gameserver.model.playable.Player;

/**
 * @author Ronn
 */
public interface QuestAction
{
	/**
	 * Method apply.
	 * @param event QuestEvent
	 */
	public void apply(QuestEvent event);
	
	/**
	 * Method getType.
	 * @return QuestActionType
	 */
	public QuestActionType getType();
	
	/**
	 * Method test.
	 * @param npc Npc
	 * @param player Player
	 * @return boolean
	 */
	public boolean test(Npc npc, Player player);
}