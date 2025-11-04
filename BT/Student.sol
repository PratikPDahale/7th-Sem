// SPDX-License-Identifier: UNLICENSED
pragma solidity ^0.8.0;

contract StudentData{

    //Structure
    struct Student{
        string name;
        uint256 rollno;
    }
    //Array

    Student[] public studentarr;

    function addStudent(string memory name, uint256 rollno) public {
        for(uint256 i =0; i < studentarr.length; i++){
            if(studentarr[i].rollno == rollno){
                revert("Student with this roll no already exists");
            }
        }
        studentarr.push(Student(name,rollno));
    }

    function getStudentsLength() public view returns(uint256){
        return studentarr.length;
    }

    function displayAllStudents() public view returns(Student[] memory){
        return studentarr;
    }

    function getStudentByIndex(uint idx) public view returns(Student memory){
        require(idx < studentarr.length, "index out of bound!");
        return studentarr[idx];
    }

    //fallback
    fallback() external payable {
        //This function will handle external function calls that is not there in our contract    
    }

    receive() external payable { 
        //This function will handle the ether sent by user but without data mentioned
    }
}