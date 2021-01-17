import React from "react";
import { TouchableOpacity, Image, Text, StyleSheet } from "react-native";
import styles from "./styles";

const Button = ({ action }) => {
    return (
        <TouchableOpacity activeOpacity={0.5} style={styles.btn} onPress={action}>
            <Image source={{ uri: 'https://reactnativecode.com/wp-content/uploads/2017/11/Floating_Button.png' }}

                style={styles.FloatingButtonStyle} />
        </TouchableOpacity>
    );
}
export default Button;