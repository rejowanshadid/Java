package interfaces;
import java.lang.*;
import entities.*;


public interface INoticeRepo
{
	void addNotice(Notice n);
	void removeNotice(String key);
	void updateNotice(Notice n);
	Notice searchNoticeByNoticeId(String id);
	Notice[] searchNoticeByUserId(String id);
	Notice[] searchNoticeBySectionId(String id);
	Notice[] getAllNotice();
	
}