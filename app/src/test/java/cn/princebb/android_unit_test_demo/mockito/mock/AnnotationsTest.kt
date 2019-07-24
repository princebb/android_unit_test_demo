package cn.princebb.android_unit_test_demo.mockito.mock

import cn.princebb.android_unit_test_demo.bean.Coworker
import org.junit.Assert
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

/**
 * author:  Allen <br>
 * date:  2019-07-23<br>
 * description:
 */
class AnnotationsTest {
    @Mock
    lateinit var coworker: Coworker

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun testIsNotNull() {
        assertNotNull(coworker)
    }
}