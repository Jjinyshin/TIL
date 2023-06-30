def gcd(a, b):
    while b != 0:
        a, b = b, a % b
    return a
def solution(numer1, denom1, numer2, denom2):
    numer = numer1 * denom2 + numer2 * denom1
    denom = denom1 * denom2
    # 최대공약수 구하고 나누기
    gcd_val = gcd(numer, denom)
    numer //= gcd_val
    denom //= gcd_val
    return [numer, denom]