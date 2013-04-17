using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;

namespace StringCalculator
{
    public static class Calculator
    {
        static string regularexpression = "//.*\\n";

        public static int Add(string value)
        {
            if (String.IsNullOrEmpty(value))
                return 0;

            string delimiter = ",";
            if (Regex.IsMatch(value, regularexpression))
            {
                delimiter = value.Substring(2, 1);
                value = Regex.Replace(value, regularexpression, "");
            }

            List<int> negativeNumbers = new List<int>();
            string[] splitted = value.Split(new string[] { delimiter, "\n" }, StringSplitOptions.RemoveEmptyEntries);

            int result = 0;
            foreach (string val in splitted)
            {
                int convertedVal = Int32.Parse(val);

                if (convertedVal < 0)
                {
                    negativeNumbers.Add(convertedVal);
                }
                else if (convertedVal < 1000)
                {
                    result += convertedVal;
                }
            }

            if (negativeNumbers.Count > 0)
            {
                throw new Exception(String.Format("Negative numbers not allowed: {0}", String.Join(",", negativeNumbers)));
            }

            return result;
        }

    }
}
