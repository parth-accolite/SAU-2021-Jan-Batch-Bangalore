function distinctPrimeFactors(num) {
    function is_prime(num) {
      for (let i = 2; i <= Math.sqrt(num); i++)
      {
        if (num % i === 0) return false;
      }
      return true;
    }
    const res = [];
    for (let i = 2; i <= num; i++)
    {
      while (is_prime(i) && num % i === 0) 
      {
        if (!res.includes(i)) res.push(i);
        num /= i;
      }
    }
    return res;
  }
  console.log(distinctPrimeFactors(100));
  console.log(distinctPrimeFactors(29));
  console.log(distinctPrimeFactors(4));
  console.log(distinctPrimeFactors(49));
  console.log(distinctPrimeFactors(53));
  