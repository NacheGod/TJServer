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
package tera.gameserver.network.serverpackets;

import tera.gameserver.model.quests.QuestState;
import tera.gameserver.network.ServerPacketType;

/**
 * @author Ronn
 */
public class QuestMoveToPanel extends ServerPacket
{
	private static final ServerPacket instance = new QuestMoveToPanel();
	
	/**
	 * Method getInstance.
	 * @param quest QuestState
	 * @return QuestMoveToPanel
	 */
	public static QuestMoveToPanel getInstance(QuestState quest)
	{
		final QuestMoveToPanel packet = (QuestMoveToPanel) instance.newInstance();
		packet.questId = quest.getQuestId();
		packet.objectId = quest.getObjectId();
		packet.state = quest.getState();
		return packet;
	}
	
	private int questId;
	private int objectId;
	private int state;
	
	/**
	 * Method getPacketType.
	 * @return ServerPacketType
	 */
	@Override
	public ServerPacketType getPacketType()
	{
		return ServerPacketType.QUEST_MOVE_TO_PANEL;
	}
	
	@Override
	protected void writeImpl()
	{
		writeOpcode();
		writeInt(questId);
		writeInt(objectId);
		writeByte(state);
	}
}