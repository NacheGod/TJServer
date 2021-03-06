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
package tera.gameserver.network.clientpackets;

import tera.gameserver.model.Guild;
import tera.gameserver.model.playable.Player;

/**
 * @author Ronn
 */
public class RequestGuildUpdateNote extends ClientPacket
{
	
	private String note;
	
	private Player player;
	
	/**
	 * Method finalyze.
	 * @see rlib.util.pools.Foldable#finalyze()
	 */
	@Override
	public void finalyze()
	{
		player = null;
		note = null;
	}
	
	@Override
	protected void readImpl()
	{
		player = owner.getOwner();
		readShort();
		note = readString();
	}
	
	@Override
	protected void runImpl()
	{
		if ((player == null) || (note.length() > 34))
		{
			return;
		}
		
		final Guild guild = player.getGuild();
		
		if (guild != null)
		{
			guild.changeMemberNote(player, note);
		}
	}
}
