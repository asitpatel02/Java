#include <iostream>
#include <iomanip>
#include <fstream>
#include <string>
using namespace std;

int main()
{
    const int size = 300;
    const int EXAMSIZE = 30;                      // <===== Number of questions
    int count;
    char correctAnswers[EXAMSIZE];                // <===== Your teacher asked for character arrays
    char studentAnswers[EXAMSIZE];
    int studentNumber = 0;


    // Read correct answers
    ifstream infileC("CorrectAnswers.txt");     // <===== Open with constructor
    if (!infileC)
    {
        cout << "Error opening correct answers file" << endl;
        return 1;                                  // <===== Stop at failure
    }
    while (!infileC.eof())
    {
        getline(infileC, correctAnswers);
    }
    infileC.close();


    ifstream infileS("StudentAnswers.txt");     // <===== Open with constructor
    if (!infileS)
    {
        cout << "Error opening student answers file" << endl;
        return 1;                                  // <===== Stop at failure
    }


    // Student by student
    while (infileS)                             // <===== Comment out this line for only one student
    {
        studentNumber++;                           // <===== Next student

        // Read answers
        for (int i = 0; i < EXAMSIZE; i++)
        {
            infileS >> studentAnswers[i];
            if (!infileS) return 0;               // <===== Need opportunity to escape if no more students (don't we all!)
            infileS.ignore(256, '\n');
        }

        // Produce report
        cout << "Report for Student " << studentNumber << ": " << endl;
        cout << "The student got the following answers wrong: " << endl;
        count = 0;
        for (int i = 0; i < EXAMSIZE; i++)
        {
            if (correctAnswers[i] != studentAnswers[i])
            {
                count++;
                cout << "Question number: " << setw(2) << i + 1
                    << "   Student answer: " << studentAnswers[i]
                    << "   Correct answer: " << correctAnswers[i] << endl;
            }
        }
        cout << endl;

        double percent = 100.0 * (EXAMSIZE - count) / EXAMSIZE;     // <===== 100.0 first prevents integer division error
        cout << "Number of questions wrong: " << count << endl;
        cout << "Percentage correct:        " << percent << endl;
        cout << endl;

        if (percent >= 70.0) cout << "This student passed the exam" << endl;
        else                   cout << "This student failed the exam" << endl;

        cout << endl << endl;
    }                                                                // <=====Comment out this line for only one student

    infileS.close();
}