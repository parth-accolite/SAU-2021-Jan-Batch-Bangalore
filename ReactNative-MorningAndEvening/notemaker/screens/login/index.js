import React, { useState, useEffect } from "react";
import { View, TextInput, Text } from "react-native";
import AsyncStorage from '@react-native-community/async-storage';
import Button from "./Button";
import styles from "./styles";
// import { AsyncStorage } from "@react-native-community/async-storage";

const Login = ({ navigation }) => {

    const [userName, setUserName] = useState("");

    const checkAuth = async () => {
        const currentUser = await AsyncStorage.getItem("userName");
        if (currentUser) {
            navigation.reset({
                index: 0,
                routes: [{ name: "view-notes" }],
            });
        }
        return;
    }

    useEffect(() => {
        checkAuth();
    }, []);

    const login = async () => {
        // console.log("inside navigation");
        await AsyncStorage.setItem("userName", userName);
        console.log(userName);
        console.log("async" + await AsyncStorage.getItem("username"));

        navigation.reset({
            index: 0,
            routes: [{ name: "view-notes" }],
        });
    }
    return (
        <View style={styles.container}>
            <Text style={styles.loginTextStyle}> Login </Text>
            <TextInput placeholder="Enter username" style={styles.textInputStyle} onChangeText={(text) => setUserName(text)} />
            <TextInput style={styles.textInputStyle} placeholder="Enter password" />
            <Button title="Login" action={login} />
        </View>
    )
}

export default Login;