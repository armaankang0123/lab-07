package com.example.lab_7


import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class DriversScreenTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()  //toacces main activity
    @Test
    fun nav_driver_add_driver_clear_and_return_home(){
        composeTestRule
            .onNodeWithTag("driversButton")
            .performClick()
        composeTestRule
            .onNodeWithText("FormulaZero Drivers")
            .assertExists()
        composeTestRule
            .onNodeWithTag("inputDriver")
            .performTextInput("Lewis Hamilton") //test with a driver's name
        composeTestRule
            .onNodeWithTag("addButtonDriver") //test add driver button
            .performClick()
        composeTestRule
            .onNodeWithText("Lewis Hamilton")  //check if driver added
            .assertExists()
        composeTestRule
            .onNodeWithTag("clearButtonDriver")  //test clear button
            .performClick()
        composeTestRule
            .onNodeWithText("Lewis Hamilton") //check if driver cleared
            .assertDoesNotExist()
        composeTestRule
            .onNodeWithTag("driversBackButton") //homescreen
            .performClick()
        composeTestRule
            .onNodeWithText("FormulaZero Home")
            .assertExists()
    }
}