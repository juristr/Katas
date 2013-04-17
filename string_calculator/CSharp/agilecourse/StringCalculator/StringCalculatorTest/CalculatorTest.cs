using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using StringCalculator;

namespace StringCalculatorTest
{
    [TestClass]
    public class CalculatorTest
    {
        [TestMethod]
        public void ShouldReturnZeroWhenPassingEmptyString()
        {
            Assert.AreEqual(0, Calculator.Add(""));
        }

        [TestMethod]
        public void ShouldReturnASingleNumber()
        {
            Assert.AreEqual(1, Calculator.Add("1"));
            Assert.AreEqual(2, Calculator.Add("2"));            
        }

        [TestMethod]
        public void ShouldAddTwoPositiveNumbers()
        {
            Assert.AreEqual(3, Calculator.Add("1,2"));
            Assert.AreEqual(14, Calculator.Add("3,11"));            
        }

        [TestMethod]
        public void ShouldAddTwoOrMoreNumbers()
        {
            Assert.AreEqual(6, Calculator.Add("3,1,2"));
            Assert.AreEqual(11, Calculator.Add("3,1,2,5"));            
        }

        [TestMethod]
        public void ShouldAcceptNewlineCharacter()
        {
            Assert.AreEqual(6, Calculator.Add("1\n2,3"));            
        }

        [TestMethod]
        public void ShouldThrowExceptionOnNegativeNumbers()
        {
            ShouldThrowException("-1", "-1");
            ShouldThrowException("-1,-2", "-1,-2");
            ShouldThrowException("-1,3,-2", "-1,-2");
        }

        [TestMethod]        
        public void ShouldThrowExceptionOnNegativeNumbers1()
        {
            ShouldThrowException("-1", "-1");
            ShouldThrowException("-1,-2", "-1,-2");
            ShouldThrowException("-1,3,-2", "-1,-2");
        }

        [TestMethod]
        public void ShouldAllowUsingADifferentDelimiter()
        {
            Assert.AreEqual(3, Calculator.Add("//;\n1;2"));
        }

        [TestMethod]
        public void ShouldIgnoreNumbersBiggerThan1000()
        {
            Assert.AreEqual(2, Calculator.Add("2,1001"));
        }

        [TestMethod]
        public void ShouldAcceptDelimitersWithAVariableLength()
        {
            Assert.AreEqual(6, Calculator.Add("//***\n1***2***3"));
        }

        private void ShouldThrowException(string calculatorString, string expectedNegatives)
        {
            bool exceptionThrown = false;
            try
            {
                Calculator.Add(calculatorString);
            }
            catch (Exception e)
            {
                exceptionThrown = true;
                Assert.AreEqual("Negative numbers not allowed: " + expectedNegatives, e.Message);
            }
            Assert.IsTrue(exceptionThrown);
        }

    }
}
