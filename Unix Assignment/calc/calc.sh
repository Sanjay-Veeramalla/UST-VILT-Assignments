echo "Enter a number:"
read a

echo "Enter another number:"
read b

echo "Enter operator (+,-,*,/):"
read op

case $op in
    +)
        res=$((a + b))
        ;;
    -)
        res=$((a - b))
        ;;
    \*)
        res=$((a * b))
        ;;
    /)
        if [ $b -eq 0 ]; then
            echo "Error: Division by zero"
            exit 1
        fi
        res=$((a / b))
        ;;
    *)
        echo "Invalid operator"
        exit 1
        ;;
esac

echo "Result: $res"
