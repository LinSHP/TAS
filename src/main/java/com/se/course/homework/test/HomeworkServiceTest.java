package com.se.course.homework.test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.se.course.homework.service.HomeworkService;
import com.se.global.dao.UserDAO;
import com.se.global.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest

@WebAppConfiguration
public class HomeworkServiceTest {

    @Resource
    private HomeworkService homeworkService;

    @Resource
    private UserDAO userDAO;

    private MultipartFile createTestFile(String filePath) {
        try {
            File file = new File(filePath);
            return new MockMultipartFile(
                    filePath.substring(filePath.lastIndexOf('/')+1),
                    filePath.substring(filePath.lastIndexOf('/')+1),
                    "text/plain",
                    new FileInputStream(file)
            );
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private Date createDate(String dateStr) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return simpleDateFormat.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
            return new Date();
        }
    }

    @Test
    public void testAssignHomework() {
        MockHttpSession mockHttpSession = new MockHttpSession();
        mockHttpSession.setAttribute("user", userDAO.getUser("3150101000"));
        assertArrayEquals(
                new Object[]{
                        homeworkService.assignHomework(mockHttpSession, "软件工程测试作业", createDate("2017-12-31"), 100,
                                "本作业为软件工程测试作业，仅作测试之用", null,
                                1),
                        homeworkService.assignHomework(mockHttpSession, "软件工程测试第二次作业", createDate("2100-01-01"), 150,
                                "本作业为软件工程测试作业，仅作测试之用第二次测试用", null,
                                1),
                        homeworkService.assignHomework(mockHttpSession, "软件工程测试第二次作业", createDate("2018-01-01"), 1,
                                "本作业为软件工程测试作业，仅作测试之用第二次测试用", null,
                                1),
                },
                new Object[]{
                        true,
                        true,
                        true,
                }

        );

        assertArrayEquals(
                new Object[]{
                        homeworkService.assignHomework(mockHttpSession, "软件工程测试作业", createDate("2017-12-31"), 100,
                                "本作业为软件工程测试作业，仅作测试之用", createTestFile("/Users/linsp/Desktop/软件工程测试作业描述.pdf"),
                                1),
                        homeworkService.assignHomework(mockHttpSession, "软件工程测试作业", createDate("2017-12-31"), 100,
                                "本作业为软件工程测试作业，仅作测试之用", createTestFile("/Users/linsp/Desktop/软件工程测试作业描述.txt"),
                                1),
                        homeworkService.assignHomework(mockHttpSession, "软件工程测试作业", createDate("2017-12-31"), 100,
                                "本作业为软件工程测试作业，仅作测试之用", createTestFile("/Users/linsp/Desktop/软件工程测试作业描述.docx"),
                                1),
                },
                new Object[] {
                        true,
                        true,
                        true,
                }
        );

        assertFalse(homeworkService.assignHomework(mockHttpSession, "", createDate("2017-12-31"), 100,
                "本作业为软件工程测试作业，仅作测试之用", null,
                1));
        assertFalse(homeworkService.assignHomework(mockHttpSession, "软件工程测试作业", createDate("2017-12-31"), 100,
                "", null,
                1));
        assertFalse(homeworkService.assignHomework(mockHttpSession, "软件工程测试作业", null, 100,
                "本作业为软件工程测试作业，仅作测试之用", null,
                1));
        assertFalse(homeworkService.assignHomework(mockHttpSession, "软件工程测试作业", createDate("2017-01-31"), 100,
                "本作业为软件工程测试作业，仅作测试之用", null,
                1));

        assertArrayEquals(
                new Object[]{
                        homeworkService.assignHomework(mockHttpSession, "软件工程测试作业软件工程测试作业软件工程测试作业软件工程测试作业软件工程测试作业软件工程测试作业软件工程测试作业软件工程测试作业软件工程测试作业软件工程测试作业软件工程测试作业软件工程测试作业软件工程测试作业软件工程测试作业软件工程测试作业软件工程测试作业软件工程测试作业软件工程测试作业软件工程测试作业软件工程测试作业软件工程测试作业软件工程测试作业软件工程测试作业软件工程测试作业软件工程测试作业", createDate("2017-12-31"), 100,
                                "本作业为软件工程测试作业，仅作测试之用", null,
                                1),
                        homeworkService.assignHomework(mockHttpSession, "软件工程测试作业", createDate("2017-12-31"), 100,
                                "本作业为软件工程测试作业，仅作测试之用本作业为软件工程测试作业，仅作测试之用本作业为软件工程测试作业，仅作测试之用本作业为软件工程测试作业，仅作测试之用本作业为软件工程测试作业，仅作测试之用本作业为软件工程测试作业，仅作测试之用本作业为软件工程测试作业，仅作测试之用本作业为软件工程测试作业，仅作测试之用本作业为软件工程测试作业，仅作测试之用本作业为软件工程测试作业，仅作测试之用本作业为软件工程测试作业，仅作测试之用本作业为软件工程测试作业，仅作测试之用本作业为软件工程测试作业，仅作测试之用本作业为软件工程测试作业，仅作测试之用本作业为软件工程测试作业，仅作测试之用本作业为软件工程测试作业，仅作测试之用本作业为软件工程测试作业，仅作测试之用本作业为软件工程测试作业，仅作测试之用本作业为软件工程测试作业，仅作测试之用本作业为软件工程测试作业，仅作测试之用本作业为软件工程测试作业，仅作测试之用本作业为软件工程测试作业，仅作测试之用本作业为软件工程测试作业，仅作测试之用本作业为软件工程测试作业，仅作测试之用本作业为软件工程测试作业，仅作测试之用本作业为软件工程测试作业，仅作测试之用本作业为软件工程测试作业，仅作测试之用本作业为软件工程测试作业，仅作测试之用本作业为软件工程测试作业，仅作测试之用本作业为软件工程测试作业，仅作测试之用本作业为软件工程测试作业，仅作测试之用本作业为软件工程测试作业，仅作测试之用本作业为软件工程测试作业，仅作测试之用本作业为软件工程测试作业，仅作测试之用本作业为软件工程测试作业，仅作测试之用本作业为软件工程测试作业，仅作测试之用本作业为软件工程测试作业，仅作测试之用本作业为软件工程测试作业，仅作测试之用本作业为软件工程测试作业，仅作测试之用本作业为软件工程测试作业，仅作测试之用", null,
                                1),
                },
                new Object[] {
                        false,
                        false
                }
        );

        assertFalse(homeworkService.assignHomework(mockHttpSession, "软件工程测试作业", createDate("2017-12-31"), 100,
                "本作业为软件工程测试作业，仅作测试之用", createTestFile("/Users/linsp/Downloads/sogou_mac_44d.dmg"),
                1));

        assertArrayEquals(
                new Object[]{
                        homeworkService.assignHomework(mockHttpSession, "\'软件工程测试作业", createDate("2017-12-31"), 100,
                                "本作业为软件工程测试作业，仅作测试之用", null,
                                1),
                        homeworkService.assignHomework(mockHttpSession, "软件工程测试作业", createDate("2017-12-31"), 100,
                                "\'本作业为软件工程测试作业，仅作测试之用", null,
                                1),
                },
                new Object[] {
                        false,
                        false
                }
        );

        assertFalse(homeworkService.assignHomework(mockHttpSession, "软件工程测试作业", createDate("2018-0-0"), 100,
                "本作业为软件工程测试作业，仅作测试之用", null,
                1));
        assertFalse(homeworkService.assignHomework(mockHttpSession, "软件工程测试作业", createDate("2017-12-31"), 100,
                "本作业为软件工程测试作业，仅作测试之用", createTestFile("/Users/linsp/Desktop/tmd1.exe"),
                1));

        assertArrayEquals(
                new Object[]{
                        homeworkService.assignHomework(mockHttpSession, "软件工程测试作业", createDate("2017-12-31"), 0,
                                "本作业为软件工程测试作业，仅作测试之用", null,
                                1),
                        homeworkService.assignHomework(mockHttpSession, "软件工程测试作业", createDate("2017-12-31"), 151,
                                "本作业为软件工程测试作业，仅作测试之用", null,
                                1),
                },
                new Object[] {
                        false,
                        false
                }
        );

        assertTrue(homeworkService.assignHomework(mockHttpSession, "软件工程测试作业", createDate("2017-12-31"), 100,
                "本作业为软件工程测试作业，仅作测试之用", createTestFile("/Users/linsp/Desktop/'软件工程测'试作业描述 .pdf"),
                1));
        assertFalse(homeworkService.assignHomework(mockHttpSession, "软件工程测试作业", createDate("2017-12-31"), 100,
                "本作业为软件工程测试作业，仅作测试之用", createTestFile("/Users/linsp/Downloads/sogou_mac_44d.dmg"),
                1));
        assertTrue(homeworkService.assignHomework(mockHttpSession, "软件工程测试作业", createDate("2017-12-31"), 100,
                "本作业为软件工程测试作业，仅作测试之用", null,
                1));

    }

}