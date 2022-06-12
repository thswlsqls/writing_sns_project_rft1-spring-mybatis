package com.ucamp.project.user;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ucamp.project.emotion.EmotionService;

@Controller
public class UserController {

	@Autowired
	private UserServive userService;
	@Autowired
	private EmotionService emotionService;
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@RequestMapping(value = "/loginUI", method = RequestMethod.GET)
	public String loginUI(){
		return "login";
	}
	
	@RequestMapping(value = "/loginAction", method = RequestMethod.POST)
	public String loginAction(HttpServletRequest request,Model model){
		//���� checkEmotion.jsp
		//���� login.jsp
		HttpSession session = request.getSession();
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		//�α��� ���� ���� üũ�ߴ��� ����
		String rememberCheck = request.getParameter("rememberCheck");
		session.setAttribute("rememberCheck", rememberCheck);
		System.out.println(rememberCheck);
		
		String url="login";
		
		try {
			String penName;
			penName = userService.login(id,pw);
			
			if(penName != null) {
				
				session.setAttribute("userId", id);
				session.setAttribute("penName", penName);
				
				Collection<String> emotions = new ArrayList<String>();
				String[] mainEmotions = {"���","�ູ","����","���","����","�г�","������","���"};
				
				try {
					int num = 0;
					while(num < 8) {
						String mainEmotion = mainEmotions[num];
						emotions.add(emotionService.getEmotionName(mainEmotion));
						num++;
					}
				
					request.setAttribute("emotions", emotions);
					url="checkEmotion";
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
				//�������� �ߴ��� ���ߴ��� ����
				if (emotionService.getMyEmotionName(id) == null) {
					url = "home";
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return url;
	}
	
	@RequestMapping(value = "/logoutAction", method = RequestMethod.GET)
	public String logout(HttpServletRequest request){
		
		HttpSession session = request.getSession();
		if(session.getAttribute("loginOK")!=null)
			session.invalidate();
		
		return "login";
	}
	
	@RequestMapping(value = "/addUserUI", method = RequestMethod.GET)
	public String addUserUI(HttpServletRequest request){
		return "addUser";
	}
	
	@RequestMapping(value = "/addUserAction", method = RequestMethod.POST)
	@PostMapping("addUserAction")
	public String addUser(HttpServletRequest request){
		String url="addUser";
		
		String id= request.getParameter("id");
		String name = request.getParameter("name"); 
		String pw = request.getParameter("pw");
		String nickName = request.getParameter("nickName");
		String emailId = request.getParameter("emailId");
		String domain = request.getParameter("domain");
		String tel = request.getParameter("tel");
		
		emailId = emailId+domain;
			try {
//				if(userService.addUser(id,name,nickName,pw,emailId, tel))
				if(userService.addUser2(id,name,nickName,pw,emailId, tel))
					url="login";
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return url;
	}
	
	@RequestMapping(value = "/checkEmotionUI", method = RequestMethod.GET)
	public String checkEmotionUI(HttpServletRequest request){

		return "checkEmotion";
	}
	
	@RequestMapping(value = "/findUserUI", method = RequestMethod.GET)
	public String findUserUI(HttpServletRequest request){

		return "findUser";
	}
	
	
//	@RequestMapping(value = "/mypageUI", method = RequestMethod.GET)
//	public String checkEmotion(HttpServletRequest request){
//	    /**writerDAO �ۼ����*/  
//		
//		return "mypage";
//	}
	
//	@RequestMapping(value = "/getMembers", method = RequestMethod.GET)
//	public String getMembers(HttpServletRequest request){
//		Collection<String> list=memberService.getMembers();
//		request.setAttribute("list", list);
//		return "getMembers";
//	}
	
}

