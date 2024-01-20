package sellyourunhappiness.api.controller;

import com.epages.restdocs.apispec.ResourceSnippetParameters;
import com.epages.restdocs.apispec.Schema;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.test.web.servlet.MockMvc;
import sellyourunhappiness.api.application.MemberBroker;
import sellyourunhappiness.api.dto.MemberResisterParam;
import sellyourunhappiness.core.application.MemberService;
import sellyourunhappiness.core.domain.Member;
import sellyourunhappiness.core.domain.enums.MemberType;

import static com.epages.restdocs.apispec.ResourceDocumentation.resource;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static com.epages.restdocs.apispec.MockMvcRestDocumentationWrapper.document;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MemberController.class)
@AutoConfigureRestDocs
class MemberControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private MemberBroker memberBroker;

    @MockBean
    private MemberService memberService;

    @Test
    void save() throws Exception {
        // given
        String name = "민규";
        String nickname = "mingyu";
        MemberType memberType = MemberType.one;

        MemberResisterParam param = new MemberResisterParam("민규", "min", "one");

        given(memberBroker.save(any(MemberResisterParam.class))).willReturn(Member.create(name, nickname, memberType));

        //when then
        mockMvc.perform(
                        RestDocumentationRequestBuilders.post("/v1/member")
                                .content(objectMapper.writeValueAsString(param))
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isCreated())
                .andDo(
                        document("member-post",
                                preprocessRequest(prettyPrint()),
                                preprocessResponse(prettyPrint()),
                                resource(ResourceSnippetParameters.builder()
                                        .tag("member API")
                                        .summary("Member API 테스트")
                                        .requestFields(
                                                fieldWithPath("name").type(JsonFieldType.STRING).description("이름"),
                                                fieldWithPath("nickname").type(JsonFieldType.STRING).description("닉네임"),
                                                fieldWithPath("grade").type(JsonFieldType.STRING).description("학년"))
                                        .responseFields(
                                                fieldWithPath("id").type(JsonFieldType.NULL).description("아이디"),
                                                fieldWithPath("name").type(JsonFieldType.STRING).description("이름"),
                                                fieldWithPath("nickname").type(JsonFieldType.STRING).description("닉네임"),
                                                fieldWithPath("grade").type(JsonFieldType.STRING).description("학년"))
                                        .requestSchema(Schema.schema("FormParameter-socialLogin"))
                                        .responseSchema(Schema.schema("UserResponse.Login"))
                                        .build())));
    }
}