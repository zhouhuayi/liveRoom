package com.liveRoom.dao.impl;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.liveRoom.bean.FriendPrivateChat;
import com.liveRoom.dao.FriendPrivateChatDao;
@Repository("friendPrivateChatDaoImpl")
public class FriendPrivateChatDaoImpl extends CommonDaoImpl<FriendPrivateChat> implements FriendPrivateChatDao{
	
	    //主键字段名
		protected final String PRIMARYKEYNAME = "id";
		//实体类名
		protected final Class<FriendPrivateChat> ROLECLASS = FriendPrivateChat.class;
	
	@Override
	public Map<String, Object> FriendChatList(int pageNum, int pageSize,
			String whereSql, Map<String, Object> orderBy) {
		StringBuffer sql = new StringBuffer();
		sql.append("select f.id,u.user_name,us.user_name uname,f.createtime,f.content")
		.append(" from friendprivatechat f")
		.append(" LEFT JOIN `user` u ON f.sendid = u.user_id")
		.append(" LEFT JOIN `user` us ON f.pickid = us.user_id");
		StringBuffer countSql = new StringBuffer();
		countSql.append("select count(*) from friendprivatechat f")
		.append(" LEFT JOIN `user` u ON f.sendid = u.user_id")
		.append(" LEFT JOIN `user` us ON f.pickid = us.user_id");
		return super.getMapListClass(sql.toString(),countSql.toString() , pageNum, pageSize, whereSql,orderBy);
	}

	@Override
	public boolean updateState(long friendchatId) {
		return super.update(ROLECLASS, "state",0, PRIMARYKEYNAME, friendchatId);
	}

	@Override
	public boolean updatesState(String friendchatIds) {
		return super.update(ROLECLASS, "state",0, PRIMARYKEYNAME, friendchatIds);
	}

}
