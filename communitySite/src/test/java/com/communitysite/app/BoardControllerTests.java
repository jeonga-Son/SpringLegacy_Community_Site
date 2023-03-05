package com.communitysite.app;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.communitysite.mapper.BoardMapperTests;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration 
@ContextConfiguration({
	"file:src/main/webapp/WEB-INF/spring/root-context.xml", 
	"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
})
@Log4j
public class BoardControllerTests {
	
	@Autowired
	private WebApplicationContext ctx; // 스프링 컨테이너 or 스프링 컨텍스
	
	private MockMvc mockMvc; // 톰캣 같은 서버
	
	@Before // 모든 테스트 전에 매번 실행되는 메서드가 된다.
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}
	
//	@Test
//	public void testList() throws Exception {
//		// MockMvcRequestBuilders를 이용해 GET 방식의 호출을 한다.
//		mockMvc.perform(MockMvcRequestBuilders.get("/board/list"))
//		.andReturn()
//		.getModelAndView()
//		.getModelMap();
//	}
	
//	@Test
//	public void testRegister() throws Exception {
//		// MockMvcRequestBuilders를 이용해 POST 방식의 호출을 한다.
//		// param을 이용해 전달해야 하는 파라미터들을 지정한다.
//		String resultPage = mockMvc.perform(MockMvcRequestBuilders.post("/board/register")
//				.param("title", "테스트 새글 제목")
//				.param("content", "테스트 새글 내용")
//				.param("writer", "user00")
//				).andReturn().getModelAndView().getViewName(); //getViewName : 최종적인 view의 이름?
//		
//		log.info(resultPage);
//	}
	
	@Test
	public void testGet() throws Exception {
		// 특정 게시물을 조회할 때 반드시 bno라는 파라미터가 필요하다.
		log.info(mockMvc.perform(MockMvcRequestBuilders
				.get("/board/get")
				.param("bno", "2"))
				.andReturn()
				.getModelAndView().getModelMap());
	}
}
